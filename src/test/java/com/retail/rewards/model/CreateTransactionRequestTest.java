package com.retail.rewards.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreateTransactionRequestTest {
    /**
     * Method under test: {@link CreateTransactionRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CreateTransactionRequest()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CreateTransactionRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(3L));
        assertTrue(createTransactionRequest.canEqual(createTransactionRequest1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CreateTransactionRequest}
     *   <li>{@link CreateTransactionRequest#setBillAmount(Double)}
     *   <li>{@link CreateTransactionRequest#setName(String)}
     *   <li>{@link CreateTransactionRequest#setPhoneNumber(String)}
     *   <li>{@link CreateTransactionRequest#setTransactionDate(LocalDate)}
     *   <li>{@link CreateTransactionRequest#toString()}
     *   <li>{@link CreateTransactionRequest#getBillAmount()}
     *   <li>{@link CreateTransactionRequest#getName()}
     *   <li>{@link CreateTransactionRequest#getPhoneNumber()}
     *   <li>{@link CreateTransactionRequest#getTransactionDate()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CreateTransactionRequest actualCreateTransactionRequest = new CreateTransactionRequest();
        actualCreateTransactionRequest.setBillAmount(10.0d);
        actualCreateTransactionRequest.setName("Name");
        actualCreateTransactionRequest.setPhoneNumber("4105551212");
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualCreateTransactionRequest.setTransactionDate(ofEpochDayResult);
        String actualToStringResult = actualCreateTransactionRequest.toString();
        assertEquals(10.0d, actualCreateTransactionRequest.getBillAmount().doubleValue());
        assertEquals("Name", actualCreateTransactionRequest.getName());
        assertEquals("4105551212", actualCreateTransactionRequest.getPhoneNumber());
        assertSame(ofEpochDayResult, actualCreateTransactionRequest.getTransactionDate());
        assertEquals(
                "CreateTransactionRequest(phoneNumber=4105551212, name=Name, billAmount=10.0, transactionDate" + "=1970-01-02)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, null);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals2() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, "Different type to CreateTransactionRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertEquals(createTransactionRequest, createTransactionRequest);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertEquals(createTransactionRequest, createTransactionRequest1);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest1.hashCode());
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(null);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(0.5d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("4105551212");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName(null);
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("+44 1865 4960636");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber(null);
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(3L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Method under test: {@link CreateTransactionRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(null);

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertNotEquals(createTransactionRequest, createTransactionRequest1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(null);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(null);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertEquals(createTransactionRequest, createTransactionRequest1);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName(null);
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName(null);
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertEquals(createTransactionRequest, createTransactionRequest1);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber(null);
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber(null);
        createTransactionRequest1.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertEquals(createTransactionRequest, createTransactionRequest1);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateTransactionRequest#equals(Object)}
     *   <li>{@link CreateTransactionRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(10.0d);
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(null);

        CreateTransactionRequest createTransactionRequest1 = new CreateTransactionRequest();
        createTransactionRequest1.setBillAmount(10.0d);
        createTransactionRequest1.setName("Name");
        createTransactionRequest1.setPhoneNumber("4105551212");
        createTransactionRequest1.setTransactionDate(null);
        assertEquals(createTransactionRequest, createTransactionRequest1);
        int expectedHashCodeResult = createTransactionRequest.hashCode();
        assertEquals(expectedHashCodeResult, createTransactionRequest1.hashCode());
    }
}

