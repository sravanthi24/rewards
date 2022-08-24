package com.retail.rewards.service;

import com.retail.rewards.entity.Customer;
import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.model.CreateTransactionRequest;
import com.retail.rewards.model.DetailedRewardPointsResponse;
import com.retail.rewards.model.GetAllRewardPoints;

import java.util.List;

public interface RewardPointsService {

     Customer getCustomerDetails(String phoneNumber);

     List<TransactionData> getTransactionDataByPhoneNumber(String phoneNumber);

     TransactionData saveTransactionData(CreateTransactionRequest request);

     List<GetAllRewardPoints> getRewardPointsForAllCustomer();

     List<GetAllRewardPoints> getCountOfRewardPointsByPhoneNumber(String phoneNumber);

     DetailedRewardPointsResponse getDetailedRewardPointsByMonth(String phoneNumber, int numberOfMonths);


}

