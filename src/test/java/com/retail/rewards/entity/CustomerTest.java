package com.retail.rewards.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Method under test: {@link Customer#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Customer()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Customer#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Customer customer = new Customer();

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertTrue(customer.canEqual(customer1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Customer}
     *   <li>{@link Customer#setCustomerId(Long)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#setPhoneNumber(String)}
     *   <li>{@link Customer#setTransactions(Set)}
     *   <li>{@link Customer#toString()}
     *   <li>{@link Customer#getCustomerId()}
     *   <li>{@link Customer#getName()}
     *   <li>{@link Customer#getPhoneNumber()}
     *   <li>{@link Customer#getTransactions()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setCustomerId(123L);
        actualCustomer.setName("Name");
        actualCustomer.setPhoneNumber("4105551212");
        HashSet<TransactionData> transactionDataSet = new HashSet<>();
        actualCustomer.setTransactions(transactionDataSet);
        String actualToStringResult = actualCustomer.toString();
        assertEquals(123L, actualCustomer.getCustomerId().longValue());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("4105551212", actualCustomer.getPhoneNumber());
        assertSame(transactionDataSet, actualCustomer.getTransactions());
        assertEquals("Customer(customerId=123, name=Name, phoneNumber=4105551212, transactions=[])", actualToStringResult);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        assertNotEquals(customer, null);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals2() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        assertNotEquals(customer, "Different type to Customer");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());
        assertEquals(customer, customer);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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
        assertEquals(customer, customer1);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer1.hashCode());
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals5() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals6() {
        Customer customer = new Customer();
        customer.setCustomerId(null);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals7() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("4105551212");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals8() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName(null);
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals9() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber("+44 1865 4960636");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals10() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName("Name");
        customer.setPhoneNumber(null);
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertNotEquals(customer, customer1);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals11() {
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

        HashSet<TransactionData> transactionDataSet = new HashSet<>();
        transactionDataSet.add(transactionData);

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(transactionDataSet);

        Customer customer2 = new Customer();
        customer2.setCustomerId(123L);
        customer2.setName("Name");
        customer2.setPhoneNumber("4105551212");
        customer2.setTransactions(new HashSet<>());
        assertNotEquals(customer1, customer2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        Customer customer = new Customer();
        customer.setCustomerId(null);
        customer.setName("Name");
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(null);
        customer1.setName("Name");
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertEquals(customer, customer1);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        Customer customer = new Customer();
        customer.setCustomerId(123L);
        customer.setName(null);
        customer.setPhoneNumber("4105551212");
        customer.setTransactions(new HashSet<>());

        Customer customer1 = new Customer();
        customer1.setCustomerId(123L);
        customer1.setName(null);
        customer1.setPhoneNumber("4105551212");
        customer1.setTransactions(new HashSet<>());
        assertEquals(customer, customer1);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer1.hashCode());
    }
}

