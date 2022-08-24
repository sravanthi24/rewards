package com.retail.rewards.controller;


import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.Error;
import com.retail.rewards.model.*;
import com.retail.rewards.service.RewardPointsService;
import com.retail.rewards.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(value ="/retail/")
public class RewardPointsController {

	@Autowired
	RewardPointsService rewardPointsService;

	@Autowired
	RequestValidator requestValidator;
	
	@GetMapping("/reward-points")
	  public ResponseEntity<List<GetAllRewardPoints>> getRewardPointsForAllCustomers(){
		List<GetAllRewardPoints> getAllRewardPoints = rewardPointsService.getRewardPointsForAllCustomer();
		if(getAllRewardPoints == null || getAllRewardPoints.isEmpty()){
			throw new RecordNotFoundException(ApiErrorCode.CUSTOMER_NOT_FOUND_REQUEST);
		}else
			return new ResponseEntity<>(getAllRewardPoints, HttpStatus.OK);
	}
	@GetMapping("/reward-points/transaction/{phone-number}")
	public ResponseEntity<List<TransactionData>> getTransactionDataByPhoneNumber(@PathVariable("phone-number") String phoneNum){
		List<TransactionData> trans = rewardPointsService.getTransactionDataByPhoneNumber(phoneNum);
		if(trans == null || trans.isEmpty()){
			throw new RecordNotFoundException(ApiErrorCode.TRANSACTION_NOT_FOUND_REQUEST);
		}else
		    return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	@GetMapping("/reward-points/{phone-number}")
	public ResponseEntity<List<GetAllRewardPoints>> getCountOfRewardPointsByPhoneNumber(@PathVariable("phone-number") @NotBlank String phoneNum ) {
		List<GetAllRewardPoints> pointsByPhoneNumber = rewardPointsService.getCountOfRewardPointsByPhoneNumber(phoneNum);
		if(pointsByPhoneNumber == null || pointsByPhoneNumber.isEmpty())
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_PHONE);
		else
		    return new ResponseEntity<>(pointsByPhoneNumber, HttpStatus.OK);
	}

	@GetMapping("/reward-points/{phone-number}/{number-of-months}")
	public ResponseEntity<DetailedRewardPointsResponse> getDetailedCountOfRewardPointsByPhoneNumberAndMonth(@PathVariable("phone-number") @NotBlank String phoneNum, @PathVariable("number-of-months") @NotBlank int months){
		DetailedRewardPointsResponse pointsByPhoneNumberAndMonths = rewardPointsService.getDetailedRewardPointsByMonth(phoneNum,months);
		if(pointsByPhoneNumberAndMonths == null)
			throw new RecordNotFoundException(ApiErrorCode.POINTS_NOT_FOUND_REQ_MONTH);
		else
			return new ResponseEntity<>(pointsByPhoneNumberAndMonths, HttpStatus.OK);
	}
	@PostMapping("transaction")
	public ResponseEntity<Object> createTransaction(@RequestBody CreateTransactionRequest request) throws Exception{
		List<Error> list = requestValidator.createRequestValidator(request);
		if(list!=null && !list.isEmpty()){
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}else {
			TransactionData trans = rewardPointsService.saveTransactionData(request);
			return new ResponseEntity<>(trans, HttpStatus.CREATED);
		}
	}
}
