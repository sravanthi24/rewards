package com.retail.rewards.service;

import com.retail.rewards.entity.Customer;
import com.retail.rewards.entity.RewardPoint;
import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.*;
import com.retail.rewards.repository.CustomerRepository;
import com.retail.rewards.repository.RewardPointRepository;
import com.retail.rewards.repository.TransactionRepository;
import com.retail.rewards.util.StringUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RewardPointsServiceImpl implements RewardPointsService {

	private CustomerRepository customerRepository;

	private TransactionRepository transactionRepository;

	private RewardPointRepository rewardPointRepository;

	public RewardPointsServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository,
			RewardPointRepository rewardPointRepository) {
		this.customerRepository = customerRepository;
		this.transactionRepository = transactionRepository;
		this.rewardPointRepository = rewardPointRepository;
	}

	/**
	 *
	 * @param phoneNumber
	 * @return Customer
	 */
	@Override
	public Customer getCustomerDetails(String phoneNumber) {
		return customerRepository.findByPhoneNumber(phoneNumber);
	}

	/**
	 *
	 * @param phoneNumber
	 * @return list of TransactionData
	 */
	@Override
	public List<TransactionData> getTransactionDataByPhoneNumber(String phoneNumber) {
		return transactionRepository.findTransactionDataByCustomerId_PhoneNumber(phoneNumber);
	}

	/**
	 *
	 * @param request
	 * @return TransactionData
	 */
	@Override
	public TransactionData saveTransactionData(CreateTransactionRequest request) {
		String THIS_METHOD = "saveTransactionData";
		TransactionData transaction = null;
		Customer objCustomer = null;
		try {
			TransactionData objTransactionData = new TransactionData();
			/* checking if the customer exist and get customer else create new customer */
			objCustomer = customerRepository.findByPhoneNumber(request.getPhoneNumber());
			if (objCustomer != null) {
				objTransactionData.setCustomerId(objCustomer);
			} else {
				objCustomer = new Customer();
				objCustomer.setName(request.getName());
				objCustomer.setPhoneNumber(request.getPhoneNumber());
				Customer newCustomer = customerRepository.save(objCustomer);
				objTransactionData.setCustomerId(newCustomer);
			}
			objTransactionData.setTransactionDate(request.getTransactionDate());
			BigDecimal billAmount = request.getBillAmount();
			objTransactionData.setBillAmount(billAmount);
			/* get all the reward points in sorted order to calculate points */
			List<RewardPoint> lstRewardPoints = rewardPointRepository.findAllByOrderByAmountLimitDesc();
			/* calculation of reward points */
			BigDecimal totalRewardPoints = new BigDecimal(0);
			if (lstRewardPoints != null && !lstRewardPoints.isEmpty()) {
				BigDecimal rewardPts = null;
				for (RewardPoint point : lstRewardPoints) {
					BigDecimal amountLimit = point.getAmountLimit();
					if  (billAmount.compareTo(amountLimit) == 1 || billAmount.compareTo(amountLimit)==0) {
						rewardPts = (billAmount.subtract(amountLimit)).multiply(BigDecimal.valueOf(point.getPoints()));
						totalRewardPoints = totalRewardPoints.add(rewardPts);
						billAmount = amountLimit;
					}
					log.info(THIS_METHOD + " :: reward points: " + rewardPts + " for customer: " + objCustomer.getCustomerId());
				}
				objTransactionData.setRewardPoints(totalRewardPoints);
			}else {
				objTransactionData.setRewardPoints(totalRewardPoints);
			}
			transaction = transactionRepository.save(objTransactionData);
		} catch (Exception exception) {
			log.error(THIS_METHOD + " :: error while saving the record");
		}
		return transaction;
	}

	@Override
	public List<GetAllRewardPoints> getRewardPointsForAllCustomer() {
		String THIS_METHOD = "getRewardPointsForAllCustomer";
		List<GetAllRewardPoints> lstOfCustomerPts = new ArrayList<>();
		/* get the count of rewards points for each customer */
		List<Object[]> listObjs = transactionRepository.getCountForAllCustomer();
		if (listObjs != null && !listObjs.isEmpty()) {
			for (Object[] object : listObjs) {
				GetAllRewardPoints points = new GetAllRewardPoints();
				points.setPhoneNumber(StringUtil.getMaskedData(String.valueOf(object[0])));
				points.setRewardPoints(String.valueOf(object[1]));
				lstOfCustomerPts.add(points);
			}
		} else {
			log.warn(THIS_METHOD + " :: no customers exist");
		}
		return lstOfCustomerPts;
	}

	@Override
	public List<GetAllRewardPoints> getCountOfRewardPointsByPhoneNumber(String phoneNumber) {
		String THIS_METHOD = "getCountOfRewardPointsByPhoneNumber";
		List<GetAllRewardPoints> lstPhnNumberPoints = new ArrayList<>();
		try {
			/* get the reward points based on phonenumber */
			List<Object[]> listObjs = transactionRepository.getRewardPointsByPhoneNumber(phoneNumber);
			for (Object[] object : listObjs) {
				GetAllRewardPoints points = new GetAllRewardPoints();
				points.setPhoneNumber(StringUtil.getMaskedData(String.valueOf(object[0])));
				points.setRewardPoints(String.valueOf(object[1]));
				lstPhnNumberPoints.add(points);
			}
			return lstPhnNumberPoints;
		} catch (Exception e) {
			log.error(THIS_METHOD + " :: no points found for this customer: " + StringUtil.getMaskedData(phoneNumber));
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_PHONE);
		}
	}

	/**
	 *
	 * @param phoneNumber
	 * @param numberOfMonths
	 * @return DetailedRewardPointsResponse
	 */
	@Override
	public DetailedRewardPointsResponse getDetailedRewardPointsByMonth(String phoneNumber, int numberOfMonths) {
		String THIS_METHOD = "getDetailedRewardPointsByMonth";
		DetailedRewardPointsResponse response = new DetailedRewardPointsResponse();
		List<RewardPointsResponse> pointsResponses = new ArrayList<>();
		try {
			LocalDate now = LocalDate.now();
			LocalDate earlier = now.minusMonths(numberOfMonths);
			List<Object[]> listObjs = transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths(phoneNumber,
					earlier);
			BigDecimal totalPoints = BigDecimal.valueOf(0);
			for (Object[] object : listObjs) {
				RewardPointsResponse points = new RewardPointsResponse();
				points.setMonthYear(String.valueOf(object[0]) + "/" + String.valueOf(object[1]));
				BigDecimal rewardPoints = (BigDecimal) object[2];
				points.setRewardPoints(rewardPoints);
				totalPoints  = totalPoints.add(rewardPoints);
				pointsResponses.add(points);
			}
			response.setTotalRewards(totalPoints);
			response.setMonthlyRewardPoints(pointsResponses);

		} catch (Exception e) {
			log.error(THIS_METHOD + " :: no points found for this customer: " + StringUtil.getMaskedData(phoneNumber));
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_MONTH);
		}
		return response;
	}

}
