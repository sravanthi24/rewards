package com.retail.rewards.controller;

import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.Error;
import com.retail.rewards.model.*;
import com.retail.rewards.service.RewardPointsService;
import com.retail.rewards.util.StringUtil;
import com.retail.rewards.validator.RequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/retail/")
@Slf4j
public class RewardPointsController {

	private RewardPointsService rewardPointsService;

	private RequestValidator requestValidator;

	public RewardPointsController(RewardPointsService rewardPointsService, RequestValidator requestValidator) {
		this.rewardPointsService = rewardPointsService;
		this.requestValidator = requestValidator;
	}

	/**
	 *
	 * @return List of All Reward points for each customer
	 */
	@GetMapping("/reward-points")
	public ResponseEntity<List<GetAllRewardPoints>> getRewardPointsForAllCustomers() {
		String THIS_METHOD = "getRewardPointsForAllCustomers";
		long lStartTime = System.currentTimeMillis();
		/* get the rewards points for each customer */
		final List<GetAllRewardPoints> getAllRewardPoints = rewardPointsService.getRewardPointsForAllCustomer();
		if (getAllRewardPoints == null || getAllRewardPoints.isEmpty()) {
			log.error(THIS_METHOD + " :: no records found :: time taken: "+ (System.currentTimeMillis()-lStartTime));
			throw new RecordNotFoundException(ApiErrorCode.CUSTOMER_NOT_FOUND_REQUEST);
		} else {
			log.info(THIS_METHOD + " :: time taken to get records: "+ (System.currentTimeMillis()-lStartTime));
			return new ResponseEntity<>(getAllRewardPoints, HttpStatus.OK);
		}
	}

	/**
	 *
	 * @param phoneNum
	 * @return TransactionData
	 * returns all the transactions with reward points by phoneNum
	 */
	@GetMapping("/reward-points/transaction/{phone-number}")
	public ResponseEntity<List<TransactionData>> getTransactionDataByPhoneNumber(
			@PathVariable("phone-number") String phoneNum) {
		String THIS_METHOD = "getTransactionDataByPhoneNumber";
		long lStartTime = System.currentTimeMillis();
		final List<TransactionData> trans = rewardPointsService.getTransactionDataByPhoneNumber(phoneNum);
		if (trans == null || trans.isEmpty()) {
			log.error(THIS_METHOD + " :: no records found :: time taken: "+ (System.currentTimeMillis()-lStartTime));
			throw new RecordNotFoundException(ApiErrorCode.TRANSACTION_NOT_FOUND_REQUEST);
		} else {
			log.info(THIS_METHOD + " :: time taken to get records: "+ (System.currentTimeMillis()-lStartTime));
			return new ResponseEntity<>(trans, HttpStatus.OK);
		}
	}

	/**
	 *
	 * @param phoneNum
	 * @return GetAllRewardPoints
	 * returns total reward points by phoneNum
	 */
	@GetMapping("/reward-points/{phone-number}")
	public ResponseEntity<List<GetAllRewardPoints>> getCountOfRewardPointsByPhoneNumber(
			@PathVariable("phone-number") @NotBlank String phoneNum) {
		String THIS_METHOD = "getCountOfRewardPointsByPhoneNumber";
		long lStartTime = System.currentTimeMillis();
		/* get the count of reward points by phone number */
		final List<GetAllRewardPoints> pointsByPhoneNumber = rewardPointsService
				.getCountOfRewardPointsByPhoneNumber(phoneNum);
		if (pointsByPhoneNumber == null || pointsByPhoneNumber.isEmpty()) {
			log.error(THIS_METHOD + " :: no records found :: time taken: "+ (System.currentTimeMillis()-lStartTime));
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_PHONE);
		} else {
			log.info(THIS_METHOD + " :: time taken to get records: "+ (System.currentTimeMillis()-lStartTime));
			return new ResponseEntity<>(pointsByPhoneNumber, HttpStatus.OK);
		}
	}

	/**
	 *
	 * @param phoneNum
	 * @param months
	 * @return DetailedRewardPointsResponse
	 * return the reward points earned in last x months by phone num
	 */
	@GetMapping("/reward-points/{phone-number}/{number-of-months}")
	public ResponseEntity<DetailedRewardPointsResponse> getDetailedCountOfRewardPointsByPhoneNumberAndMonth(
			@PathVariable("phone-number") @NotBlank String phoneNum,
			@PathVariable("number-of-months") @NotBlank int months) {
		String THIS_METHOD = "getDetailedCountOfRewardPointsByPhoneNumberAndMonth";
		long lStartTime = System.currentTimeMillis();
		/* get the reward points earned in last x number of months */
		final DetailedRewardPointsResponse pointsByPhoneNumberAndMonths = rewardPointsService
				.getDetailedRewardPointsByMonth(phoneNum, months);
		if (pointsByPhoneNumberAndMonths == null) {
			log.error(THIS_METHOD + " :: no records found :: time taken: "+ (System.currentTimeMillis()-lStartTime));
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_MONTH);
		} else {
			log.info(THIS_METHOD + " :: time taken to get records: "+ (System.currentTimeMillis()-lStartTime));
			return new ResponseEntity<>(pointsByPhoneNumberAndMonths, HttpStatus.OK);
		}
	}

	/**
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("transaction")
	public ResponseEntity<Object> createTransaction(@RequestBody CreateTransactionRequest request) throws Exception {
		final List<Error> lstError = requestValidator.createRequestValidator(request);
		ResponseEntity response = null;
		if (lstError != null && !lstError.isEmpty()) {
			response = new ResponseEntity<>(lstError, HttpStatus.BAD_REQUEST);
		} else {
			TransactionData objTransactionData = rewardPointsService.saveTransactionData(request);
			objTransactionData.getCustomerId().setPhoneNumber(StringUtil.getMaskedData(objTransactionData.getCustomerId().getPhoneNumber()));
			response = new ResponseEntity<>(objTransactionData, HttpStatus.CREATED);
		}
		return response;
	}
}
