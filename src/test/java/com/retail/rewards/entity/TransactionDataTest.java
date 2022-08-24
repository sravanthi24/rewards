package com.retail.rewards.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer);
        transactionData1.setRewardPoints(3L);
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(3L));
        transactionData1.setTransactionId(123L);
        assertTrue(transactionData.canEqual(transactionData1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link TransactionData}
     *   <li>{@link TransactionData#setBillAmount(Double)}
     *   <li>{@link TransactionData#setCount(Long)}
     *   <li>{@link TransactionData#setCustomerId(Customer)}
     *   <li>{@link TransactionData#setRewardPoints(Long)}
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
        actualTransactionData.setBillAmount(10.0d);
        actualTransactionData.setCount(3L);
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        actualTransactionData.setCustomerId(customer);
        actualTransactionData.setRewardPoints(1L);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualTransactionData.setTransactionDate(ofEpochDayResult);
        actualTransactionData.setTransactionId(123L);
        String actualToStringResult = actualTransactionData.toString();
        assertEquals(10.0d, actualTransactionData.getBillAmount().doubleValue());
        assertEquals(3L, actualTransactionData.getCount().longValue());
        assertSame(customer, actualTransactionData.getCustomerId());
        assertEquals(1L, actualTransactionData.getRewardPoints().longValue());
        assertSame(ofEpochDayResult, actualTransactionData.getTransactionDate());
        assertEquals(123L, actualTransactionData.getTransactionId().longValue());
        assertEquals(
                "TransactionData(transactionId=123, customerId=Customer(customerId=123, name=Name, phoneNumber=4105551212,"
                        + " transactions=[]), transactionDate=1970-01-02, billAmount=10.0, rewardPoints=1, count=3)",
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(null);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(0.5d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(1L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(null);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(3L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(null);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(1L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals13() {
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(null);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals14() {
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(null);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(123L);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(null);
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(123L);
        assertNotEquals(transactionData, transactionData1);
    }

    /**
     * Method under test: {@link TransactionData#equals(Object)}
     */
    @Test
    void testEquals15() {
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
        transactionData.setBillAmount(10.0d);
        transactionData.setCount(3L);
        transactionData.setCustomerId(customer);
        transactionData.setRewardPoints(1L);
        transactionData.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData.setTransactionId(null);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());

        TransactionData transactionData1 = new TransactionData();
        transactionData1.setBillAmount(10.0d);
        transactionData1.setCount(3L);
        transactionData1.setCustomerId(customer1);
        transactionData1.setRewardPoints(1L);
        transactionData1.setTransactionDate(LocalDate.ofEpochDay(1L));
        transactionData1.setTransactionId(null);
        assertNotEquals(transactionData, transactionData1);
    }
}

