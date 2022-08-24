package com.retail.rewards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.retail.rewards.exception.RecordNotFoundException;
import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.GetAllRewardPoints;
import com.retail.rewards.repository.CustomerRepository;
import com.retail.rewards.repository.RewardPointRepository;
import com.retail.rewards.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

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
    void testGetCountOfRewardPointsByPhoneNumber5() {
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
}

