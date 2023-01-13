package com.retail.rewards.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.rewards.entity.Customer;
import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.model.CreateTransactionRequest;
import com.retail.rewards.model.DetailedRewardPointsResponse;
import com.retail.rewards.model.Error;
import com.retail.rewards.model.GetAllRewardPoints;
import com.retail.rewards.service.RewardPointsService;
import com.retail.rewards.validator.RequestValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RewardPointsController.class})
@ExtendWith(SpringExtension.class)
class RewardPointsControllerTest {
    @MockBean
    private RequestValidator requestValidator;

    @Autowired
    private RewardPointsController rewardPointsController;

    @MockBean
    private RewardPointsService rewardPointsService;

    /**
     * Method under test: {@link RewardPointsController#getTransactionDataByPhoneNumber(String)}
     */
    @Test
    void testGetTransactionDataByPhoneNumber() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("?");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        ArrayList<TransactionData> transactionDataList = new ArrayList<>();
        transactionDataList.add(transactionData);
        when(rewardPointsService.getTransactionDataByPhoneNumber((String) any())).thenReturn(transactionDataList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/retail/reward-points/transaction/{phone-number}", "4105551212");
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"customerId\":{\"name\":\"?\",\"phoneNumber\":\"4105551212\"},\"transactionDate\":[1970,1,2],\"billAmount\":42,"
                                        + "\"rewardPoints\":42}]"));
    }

    /**
     * Method under test: {@link RewardPointsController#getTransactionDataByPhoneNumber(String)}
     */
    @Test
    void testGetTransactionDataByPhoneNumber2() throws Exception {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("?");

        ArrayList<GetAllRewardPoints> getAllRewardPointsList = new ArrayList<>();
        getAllRewardPointsList.add(getAllRewardPoints);
        when(rewardPointsService.getCountOfRewardPointsByPhoneNumber((String) any())).thenReturn(getAllRewardPointsList);
        when(rewardPointsService.getTransactionDataByPhoneNumber((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/retail/reward-points/transaction/{phone-number}", null, "Uri Variables");
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("[{\"phoneNumber\":\"4105551212\",\"rewardPoints\":\"?\"}]"));
    }

    /**
     * Method under test: {@link RewardPointsController#createTransaction(CreateTransactionRequest)}
     */
    @Test
    void testCreateTransaction() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(rewardPointsService.saveTransactionData((CreateTransactionRequest) any())).thenReturn(transactionData);
        when(requestValidator.createRequestValidator((CreateTransactionRequest) any())).thenReturn(new ArrayList<>());

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(null);
        String content = (new ObjectMapper()).writeValueAsString(createTransactionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/retail/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"customerId\":{\"name\":\"Name\",\"phoneNumber\":\"XXXXXXX212\"},\"transactionDate\":[1970,1,2],\"billAmount\":42"
                                        + ",\"rewardPoints\":42}"));
    }

    /**
     * Method under test: {@link RewardPointsController#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber() throws Exception {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("?");

        ArrayList<GetAllRewardPoints> getAllRewardPointsList = new ArrayList<>();
        getAllRewardPointsList.add(getAllRewardPoints);
        when(rewardPointsService.getCountOfRewardPointsByPhoneNumber((String) any())).thenReturn(getAllRewardPointsList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/retail/reward-points/{phone-number}",
                "4105551212");
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("[{\"phoneNumber\":\"4105551212\",\"rewardPoints\":\"?\"}]"));
    }

    /**
     * Method under test: {@link RewardPointsController#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber2() throws Exception {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("?");

        ArrayList<GetAllRewardPoints> getAllRewardPointsList = new ArrayList<>();
        getAllRewardPointsList.add(getAllRewardPoints);
        when(rewardPointsService.getRewardPointsForAllCustomer()).thenReturn(getAllRewardPointsList);
        when(rewardPointsService.getCountOfRewardPointsByPhoneNumber((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/retail/reward-points/{phone-number}",
                null, "Uri Variables");
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("[{\"phoneNumber\":\"4105551212\",\"rewardPoints\":\"?\"}]"));
    }

    /**
     * Method under test: {@link RewardPointsController#createTransaction(CreateTransactionRequest)}
     */
    @Test
    void testCreateTransaction2() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(rewardPointsService.saveTransactionData((CreateTransactionRequest) any())).thenReturn(transactionData);
        when(requestValidator.createRequestValidator((CreateTransactionRequest) any())).thenReturn(new ArrayList<>());

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(null);
        String content = (new ObjectMapper()).writeValueAsString(createTransactionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/retail/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"customerId\":{\"name\":\"Name\",\"phoneNumber\":\"\"},\"transactionDate\":[1970,1,2],\"billAmount\":42,\"rewardPoints"
                                        + "\":42}"));
    }

    /**
     * Method under test: {@link RewardPointsController#createTransaction(CreateTransactionRequest)}
     */
    @Test
    void testCreateTransaction3() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(rewardPointsService.saveTransactionData((CreateTransactionRequest) any())).thenReturn(transactionData);

        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");

        ArrayList<Error> errorList = new ArrayList<>();
        errorList.add(error);
        when(requestValidator.createRequestValidator((CreateTransactionRequest) any())).thenReturn(errorList);

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(null);
        String content = (new ObjectMapper()).writeValueAsString(createTransactionRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/retail/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"errorCode\":\"An error occurred\",\"errorDescription\":\"An error occurred\"}]"));
    }

    /**
     * Method under test: {@link RewardPointsController#getDetailedCountOfRewardPointsByPhoneNumberAndMonth(String, int)}
     */
    @Test
    void testGetDetailedCountOfRewardPointsByPhoneNumberAndMonth() throws Exception {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));
        when(rewardPointsService.getDetailedRewardPointsByMonth((String) any(), anyInt()))
                .thenReturn(detailedRewardPointsResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/retail/reward-points/{phone-number}/{number-of-months}", "4105551212", 10);
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"totalRewards\":42,\"monthlyRewardPoints\":[]}"));
    }

    /**
     * Method under test: {@link RewardPointsController#getRewardPointsForAllCustomers()}
     */
    @Test
    void testGetRewardPointsForAllCustomers() throws Exception {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("?");

        ArrayList<GetAllRewardPoints> getAllRewardPointsList = new ArrayList<>();
        getAllRewardPointsList.add(getAllRewardPoints);
        when(rewardPointsService.getRewardPointsForAllCustomer()).thenReturn(getAllRewardPointsList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/retail/reward-points");
        MockMvcBuilders.standaloneSetup(rewardPointsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("[{\"phoneNumber\":\"4105551212\",\"rewardPoints\":\"?\"}]"));
    }
}

