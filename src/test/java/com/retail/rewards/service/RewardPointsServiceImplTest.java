package com.retail.rewards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.retail.rewards.entity.Customer;
import com.retail.rewards.entity.RewardPoint;
import com.retail.rewards.entity.TransactionData;
import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.CreateTransactionRequest;
import com.retail.rewards.model.DetailedRewardPointsResponse;
import com.retail.rewards.model.GetAllRewardPoints;
import com.retail.rewards.model.RewardPointsResponse;
import com.retail.rewards.repository.CustomerRepository;
import com.retail.rewards.repository.RewardPointRepository;
import com.retail.rewards.repository.TransactionRepository;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RewardPointsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RewardPointsServiceImplTest {
    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private RewardPointRepository rewardPointRepository;

    @Autowired
    private RewardPointsServiceImpl rewardPointsServiceImpl;

    @MockBean
    private TransactionRepository transactionRepository;

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCustomerDetails(String)}
     */
    @Test
    void testGetCustomerDetails() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        when(customerRepository.findByPhoneNumber((String) any())).thenReturn(customer);
        assertSame(customer, rewardPointsServiceImpl.getCustomerDetails("4105551212"));
        verify(customerRepository).findByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCustomerDetails(String)}
     */
    @Test
    void testGetCustomerDetails2() {
        when(customerRepository.findByPhoneNumber((String) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class, () -> rewardPointsServiceImpl.getCustomerDetails("4105551212"));
        verify(customerRepository).findByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getTransactionDataByPhoneNumber(String)}
     */
    @Test
    void testGetTransactionDataByPhoneNumber() {
        ArrayList<TransactionData> transactionDataList = new ArrayList<>();
        when(transactionRepository.findTransactionDataByCustomerId_PhoneNumber((String) any()))
                .thenReturn(transactionDataList);
        List<TransactionData> actualTransactionDataByPhoneNumber = rewardPointsServiceImpl
                .getTransactionDataByPhoneNumber("4105551212");
        assertSame(transactionDataList, actualTransactionDataByPhoneNumber);
        assertTrue(actualTransactionDataByPhoneNumber.isEmpty());
        verify(transactionRepository).findTransactionDataByCustomerId_PhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getTransactionDataByPhoneNumber(String)}
     */
    @Test
    void testGetTransactionDataByPhoneNumber2() {
        when(transactionRepository.findTransactionDataByCustomerId_PhoneNumber((String) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getTransactionDataByPhoneNumber("4105551212"));
        verify(transactionRepository).findTransactionDataByCustomerId_PhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#saveTransactionData(CreateTransactionRequest)}
     */
    @Test
    void testSaveTransactionData() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        when(customerRepository.findByPhoneNumber((String) any())).thenReturn(customer);
        when(customerRepository.save((Customer) any())).thenReturn(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerId(123L);
        customer2.setName("Name");
        customer2.setPhoneNumber("4105551212");
        customer2.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer2);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(transactionRepository.save((TransactionData) any())).thenReturn(transactionData);
        when(rewardPointRepository.findAllByOrderByAmountLimitDesc()).thenReturn(new ArrayList<>());

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        TransactionData actualSaveTransactionDataResult = rewardPointsServiceImpl
                .saveTransactionData(createTransactionRequest);
        assertSame(transactionData, actualSaveTransactionDataResult);
        assertEquals("42", actualSaveTransactionDataResult.getBillAmount().toString());
        assertEquals("42", actualSaveTransactionDataResult.getRewardPoints().toString());
        verify(customerRepository).findByPhoneNumber((String) any());
        verify(transactionRepository).save((TransactionData) any());
        verify(rewardPointRepository).findAllByOrderByAmountLimitDesc();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#saveTransactionData(CreateTransactionRequest)}
     */
    @Test
    void testSaveTransactionData2() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        when(customerRepository.findByPhoneNumber((String) any())).thenReturn(customer);
        when(customerRepository.save((Customer) any())).thenReturn(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerId(123L);
        customer2.setName("Name");
        customer2.setPhoneNumber("4105551212");
        customer2.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer2);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(transactionRepository.save((TransactionData) any())).thenReturn(transactionData);
        when(rewardPointRepository.findAllByOrderByAmountLimitDesc())
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNull(rewardPointsServiceImpl.saveTransactionData(createTransactionRequest));
        verify(customerRepository).findByPhoneNumber((String) any());
        verify(rewardPointRepository).findAllByOrderByAmountLimitDesc();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#saveTransactionData(CreateTransactionRequest)}
     */
    @Test
    void testSaveTransactionData3() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        when(customerRepository.findByPhoneNumber((String) any())).thenReturn(customer);
        when(customerRepository.save((Customer) any())).thenReturn(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerId(123L);
        customer2.setName("Name");
        customer2.setPhoneNumber("4105551212");
        customer2.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer2);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);
        when(transactionRepository.save((TransactionData) any())).thenReturn(transactionData);

        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);

        ArrayList<RewardPoint> rewardPointList = new ArrayList<>();
        rewardPointList.add(rewardPoint);
        when(rewardPointRepository.findAllByOrderByAmountLimitDesc()).thenReturn(rewardPointList);

        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        TransactionData actualSaveTransactionDataResult = rewardPointsServiceImpl
                .saveTransactionData(createTransactionRequest);
        assertSame(transactionData, actualSaveTransactionDataResult);
        assertEquals("42", actualSaveTransactionDataResult.getBillAmount().toString());
        assertEquals("42", actualSaveTransactionDataResult.getRewardPoints().toString());
        verify(customerRepository).findByPhoneNumber((String) any());
        verify(transactionRepository).save((TransactionData) any());
        verify(rewardPointRepository).findAllByOrderByAmountLimitDesc();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getRewardPointsForAllCustomer()}
     */
    @Test
    void testGetRewardPointsForAllCustomer() {
        when(transactionRepository.getCountForAllCustomer()).thenReturn(new ArrayList<>());
        assertTrue(rewardPointsServiceImpl.getRewardPointsForAllCustomer().isEmpty());
        verify(transactionRepository).getCountForAllCustomer();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getRewardPointsForAllCustomer()}
     */
    @Test
    void testGetRewardPointsForAllCustomer3() {
        when(transactionRepository.getCountForAllCustomer())
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class, () -> rewardPointsServiceImpl.getRewardPointsForAllCustomer());
        verify(transactionRepository).getCountForAllCustomer();
    }
    /**
     * Method under test: {@link RewardPointsServiceImpl#getRewardPointsForAllCustomer()}
     */
    @Test
    void testGetRewardPointsForAllCustomer5() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42", "42"});
        when(transactionRepository.getCountForAllCustomer()).thenReturn(objectArrayList);
        List<GetAllRewardPoints> actualRewardPointsForAllCustomer = rewardPointsServiceImpl
                .getRewardPointsForAllCustomer();
        assertEquals(1, actualRewardPointsForAllCustomer.size());
        GetAllRewardPoints getResult = actualRewardPointsForAllCustomer.get(0);
        assertEquals("42", getResult.getPhoneNumber());
        assertEquals("42", getResult.getRewardPoints());
        verify(transactionRepository).getCountForAllCustomer();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getRewardPointsForAllCustomer()}
     */
    @Test
    void testGetRewardPointsForAllCustomer6() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"getRewardPointsForAllCustomer", "42"});
        when(transactionRepository.getCountForAllCustomer()).thenReturn(objectArrayList);
        List<GetAllRewardPoints> actualRewardPointsForAllCustomer = rewardPointsServiceImpl
                .getRewardPointsForAllCustomer();
        assertEquals(1, actualRewardPointsForAllCustomer.size());
        GetAllRewardPoints getResult = actualRewardPointsForAllCustomer.get(0);
        assertEquals("XXXXXXXXXXXXXXXXXXXXXXXXXXmer", getResult.getPhoneNumber());
        assertEquals("42", getResult.getRewardPoints());
        verify(transactionRepository).getCountForAllCustomer();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getRewardPointsForAllCustomer()}
     */
    @Test
    void testGetRewardPointsForAllCustomer7() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"", "42"});
        when(transactionRepository.getCountForAllCustomer()).thenReturn(objectArrayList);
        List<GetAllRewardPoints> actualRewardPointsForAllCustomer = rewardPointsServiceImpl
                .getRewardPointsForAllCustomer();
        assertEquals(1, actualRewardPointsForAllCustomer.size());
        GetAllRewardPoints getResult = actualRewardPointsForAllCustomer.get(0);
        assertEquals("", getResult.getPhoneNumber());
        assertEquals("42", getResult.getRewardPoints());
        verify(transactionRepository).getCountForAllCustomer();
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber() {
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any())).thenReturn(new ArrayList<>());
        assertTrue(rewardPointsServiceImpl.getCountOfRewardPointsByPhoneNumber("4105551212").isEmpty());
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber2() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42"});
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any())).thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getCountOfRewardPointsByPhoneNumber("4105551212"));
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber3() {
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getCountOfRewardPointsByPhoneNumber("4105551212"));
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber4() {
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getCountOfRewardPointsByPhoneNumber(""));
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber5() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{});
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any())).thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getCountOfRewardPointsByPhoneNumber("4105551212"));
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getCountOfRewardPointsByPhoneNumber(String)}
     */
    @Test
    void testGetCountOfRewardPointsByPhoneNumber6() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42", "42"});
        when(transactionRepository.getRewardPointsByPhoneNumber((String) any())).thenReturn(objectArrayList);
        List<GetAllRewardPoints> actualCountOfRewardPointsByPhoneNumber = rewardPointsServiceImpl
                .getCountOfRewardPointsByPhoneNumber("4105551212");
        assertEquals(1, actualCountOfRewardPointsByPhoneNumber.size());
        GetAllRewardPoints getResult = actualCountOfRewardPointsByPhoneNumber.get(0);
        assertEquals("42", getResult.getPhoneNumber());
        assertEquals("42", getResult.getRewardPoints());
        verify(transactionRepository).getRewardPointsByPhoneNumber((String) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenReturn(objectArrayList);
        DetailedRewardPointsResponse actualDetailedRewardPointsByMonth = rewardPointsServiceImpl
                .getDetailedRewardPointsByMonth("4105551212", 10);
        assertEquals(objectArrayList, actualDetailedRewardPointsByMonth.getMonthlyRewardPoints());
        assertEquals(new BigDecimal(0), actualDetailedRewardPointsByMonth.getTotalRewards());
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth2() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42"});
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("4105551212", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth3() {
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("4105551212", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth4() {
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenThrow(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        assertThrows(RecordNotFoundException.class, () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth5() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{});
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("4105551212", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth6() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42", "42"});
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("4105551212", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }

    /**
     * Method under test: {@link RewardPointsServiceImpl#getDetailedRewardPointsByMonth(String, int)}
     */
    @Test
    void testGetDetailedRewardPointsByMonth8() {
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        objectArrayList.add(new Object[]{"42", "42", "getDetailedRewardPointsByMonth"});
        when(transactionRepository.getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any()))
                .thenReturn(objectArrayList);
        assertThrows(RecordNotFoundException.class,
                () -> rewardPointsServiceImpl.getDetailedRewardPointsByMonth("4105551212", 10));
        verify(transactionRepository).getDetailedRewardPointsByPhoneNumberAndMonths((String) any(), (LocalDate) any());
    }
}

