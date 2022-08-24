package com.retail.rewards.service;

import com.retail.rewards.entity.Customer;
import com.retail.rewards.entity.RewardPoint;
import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.*;
import com.retail.rewards.repository.CustomerRepository;
import com.retail.rewards.repository.RewardPointRepository;
import com.retail.rewards.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RewardPointsServiceImpl implements RewardPointsService{


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RewardPointRepository rewardPointRepository;



    @Override
    public Customer getCustomerDetails(String phoneNumber) {
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber);
        getRewardPointsForAllCustomer();
        return customer;
    }

    @Override
    public List<TransactionData> getTransactionDataByPhoneNumber(String phoneNumber) {
        List<TransactionData> transactionData = transactionRepository.findTransactionDataByCustomerId_PhoneNumber(phoneNumber);
        return transactionData;
    }

    @Override
    public TransactionData saveTransactionData(CreateTransactionRequest request) {
        TransactionData transaction =null;
            Customer cust = null;
            TransactionData trans = new TransactionData();
            cust = customerRepository.findByPhoneNumber(request.getPhoneNumber());
            if (cust != null) {
                trans.setCustomerId(cust);
            } else {
                cust = new Customer();
                cust.setName(request.getName());
                cust.setPhoneNumber(request.getPhoneNumber());
                Customer newCustomer = customerRepository.save(cust);
                trans.setCustomerId(newCustomer);
            }
            trans.setTransactionDate(request.getTransactionDate());
            Double amount = request.getBillAmount();
            trans.setBillAmount(amount);
            List<RewardPoint> rewardPoints = rewardPointRepository.findAll();
            long rewardPts = 0;
            if(rewardPoints!=null && !rewardPoints.isEmpty()){
            for (int i = rewardPoints.size() - 1; i >= 0; i--) {
                Long limit = rewardPoints.get(i).getAmountLimit();
                if (amount > limit) {
                    rewardPts += (amount - limit) * rewardPoints.get(i).getPoints();
                    amount = Double.valueOf(limit);
                }
                log.info("reward points" + rewardPts);
            }
                 trans.setRewardPoints(rewardPts);
            }else{
                trans.setRewardPoints(rewardPts);
            }
            transaction = transactionRepository.save(trans);
        return transaction;
    }

    @Override
    public List<GetAllRewardPoints> getRewardPointsForAllCustomer() {
        List<GetAllRewardPoints> list = new ArrayList<>();
        List<Object[]> listObjs = transactionRepository.getCountForAllCustomer();
        for (Object[] object : listObjs) {
            GetAllRewardPoints points = new GetAllRewardPoints();
            points.setPhoneNumber(String.valueOf(object[0]));
            points.setRewardPoints(String.valueOf(object[1]));
            list.add(points);
        }
        return list;
    }

    @Override
    public List<GetAllRewardPoints> getCountOfRewardPointsByPhoneNumber(String phoneNumber) {
        List<GetAllRewardPoints> list = new ArrayList<>();
        try {
            List<Object[]> listObjs = transactionRepository.getRewardPointsByPhoneNumber(phoneNumber);
            for (Object[] object : listObjs) {
                GetAllRewardPoints points = new GetAllRewardPoints();
                points.setPhoneNumber(String.valueOf(object[0]));
                points.setRewardPoints(String.valueOf(object[1]));
                list.add(points);
            }
            return list;
        }catch(Exception e){
            throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_PHONE);
        }
    }

    @Override
    public DetailedRewardPointsResponse getDetailedRewardPointsByMonth(String phoneNumber, int numberOfMonths) {
        DetailedRewardPointsResponse response = new DetailedRewardPointsResponse();
        List<RewardPointsResponse> pointsResponses = new ArrayList<>();
        try {
            LocalDate now = LocalDate.now(); // 2015-11-24
            LocalDate earlier = now.minusMonths(numberOfMonths);
            List<Object[]> listObjs = transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths(phoneNumber, earlier);
            long totalPoints = 0;
            for (Object[] object : listObjs) {
                RewardPointsResponse points = new RewardPointsResponse();
                points.setMonthYear(String.valueOf(object[0])+"/"+String.valueOf(object[1]));
                Long rewardPoints = Long.parseLong(String.valueOf(object[2]));
                points.setRewardPoints(rewardPoints);
                totalPoints+=rewardPoints;
                pointsResponses.add(points);
            }
            response.setTotalRewards(totalPoints);
            response.setMonthlyRewardPoints(pointsResponses);

        }catch(Exception e){
            throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_MONTH);
        }
        return response;
    }

}
