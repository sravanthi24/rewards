package com.retail.rewards.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TransactionDataTest {
    /**
     * Method under test: {@link TransactionData#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new TransactionData()).canEqual("Other"));
    }

    /**
     * Method under test: {@link TransactionData#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        TransactionData transactionData = new TransactionData();

        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(3L));
        transactionData1.setTransactionId(123L);
        assertTrue(transactionData.canEqual(transactionData1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link TransactionData}
     *   <li>{@link TransactionData#setBillAmount(BigDecimal)}
     *   <li>{@link TransactionData#setCount(Long)}
     *   <li>{@link TransactionData#setCustomerId(Customer)}
     *   <li>{@link TransactionData#setRewardPoints(BigDecimal)}
     *   <li>{@link TransactionData#setTransactionDate(LocalDate)}
     *   <li>{@link TransactionData#setTransactionId(Long)}
     *   <li>{@link TransactionData#toString()}
     *   <li>{@link TransactionData#getBillAmount()}
     *   <li>{@link TransactionData#getCount()}
     *   <li>{@link TransactionData#getCustomerId()}
     *   <li>{@link TransactionData#getRewardPoints()}
     *   <li>{@link TransactionData#getTransactionDate()}
     *   <li>{@link TransactionData#getTransactionId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TransactionData actualTransactionData = new TransactionData();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualTransactionData.setBillAmount(valueOfResult);
        actualTransactionData.setCount(3L);
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        actualTransactionData.setCustomerId(customer);
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualTransactionData.setRewardPoints(valueOfResult1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualTransactionData.setTransactionDate(ofEpochDayResult);
        actualTransactionData.setTransactionId(123L);
        String actualToStringResult = actualTransactionData.toString();
        BigDecimal billAmount = actualTransactionData.getBillAmount();
        assertSame(valueOfResult, billAmount);
        assertEquals(valueOfResult1, billAmount);
        assertEquals(3L, actualTransactionData.getCount().longValue());
        assertSame(customer, actualTransactionData.getCustomerId());
        BigDecimal rewardPoints = actualTransactionData.getRewardPoints();
        assertSame(valueOfResult1, rewardPoints);
        assertEquals(billAmount, rewardPoints);
        assertSame(ofEpochDayResult, actualTransactionData.getTransactionDate());
        assertEquals(123L, actualTransactionData.getTransactionId().longValue());
        assertEquals(
                "TransactionData(transactionId=123, customerId=Customer(customerId=123, name=Name, phoneNumber=4105551212,"
                        + " transactions=[]), transactionDate=1970-01-02, billAmount=42, rewardPoints=42, count=3)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(transactionData, null);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(transactionData, "Different type to TransactionData");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TransactionData#equals(Object)}
     *   <li>{@link TransactionData#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(transactionData, transactionData);
        int expectedHashCodeResult = transactionData.hashCode();
        assertEquals(expectedHashCodeResult, transactionData.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TransactionData#equals(Object)}
     *   <li>{@link TransactionData#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertEquals(transactionData, transactionData1);
        int expectedHashCodeResult = transactionData.hashCode();
        assertEquals(expectedHashCodeResult, transactionData1.hashCode());
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals5() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(1L));
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals6() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(null);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals7() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(1L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals8() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        TransactionData transactionData = new TransactionData();
        transactionData.setBillAmount(BigDecimal.valueOf(42L));
        transactionData.setCount(null);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals9() {
        Customer customer = mock(Customer.class);
        doNothing().when(customer).setCustomerId((Long) any());
        doNothing().when(customer).setName((String) any());
        doNothing().when(customer).setPhoneNumber((String) any());
        doNothing().when(customer).setTransactions((Set<TransactionData>) any());
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

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals10() {
        Customer customer = mock(Customer.class);
        doNothing().when(customer).setCustomerId((Long) any());
        doNothing().when(customer).setName((String) any());
        doNothing().when(customer).setPhoneNumber((String) any());
        doNothing().when(customer).setTransactions((Set<TransactionData>) any());
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
        transactionData.setTransactionId(1L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals11() {
        Customer customer = mock(Customer.class);
        doNothing().when(customer).setCustomerId((Long) any());
        doNothing().when(customer).setName((String) any());
        doNothing().when(customer).setPhoneNumber((String) any());
        doNothing().when(customer).setTransactions((Set<TransactionData>) any());
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
        transactionData.setTransactionId(null);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals12() {
        Customer customer = mock(Customer.class);
        doNothing().when(customer).setCustomerId((Long) any());
        doNothing().when(customer).setName((String) any());
        doNothing().when(customer).setPhoneNumber((String) any());
        doNothing().when(customer).setTransactions((Set<TransactionData>) any());
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
        transactionData.setTransactionId(null);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(BigDecimal.valueOf(42L));
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(BigDecimal.valueOf(42L));
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(null);
        assertNotEquals(transactionData, transactionData1);
    }
}

