package com.retail.rewards.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ErrorTest {
    /**
     * Method under test: {@link Error#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Error()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Error#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Error error = new Error();

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertTrue(error.canEqual(error1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Error}
     *   <li>{@link Error#setErrorCode(String)}
     *   <li>{@link Error#setErrorDescription(String)}
     *   <li>{@link Error#toString()}
     *   <li>{@link Error#getErrorCode()}
     *   <li>{@link Error#getErrorDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Error actualError = new Error();
        actualError.setErrorCode("An error occurred");
        actualError.setErrorDescription("An error occurred");
        String actualToStringResult = actualError.toString();
        assertEquals("An error occurred", actualError.getErrorCode());
        assertEquals("An error occurred", actualError.getErrorDescription());
        assertEquals("Error(errorCode=An error occurred, errorDescription=An error occurred)", actualToStringResult);
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");
        assertNotEquals(error, null);
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals2() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");
        assertNotEquals(error, "Different type to Error");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Error#equals(Object)}
     *   <li>{@link Error#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");
        assertEquals(error, error);
        int expectedHashCodeResult = error.hashCode();
        assertEquals(expectedHashCodeResult, error.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Error#equals(Object)}
     *   <li>{@link Error#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertEquals(error, error1);
        int expectedHashCodeResult = error.hashCode();
        assertEquals(expectedHashCodeResult, error1.hashCode());
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals5() {
        Error error = new Error();
        error.setErrorCode("Error Code");
        error.setErrorDescription("An error occurred");

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertNotEquals(error, error1);
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals6() {
        Error error = new Error();
        error.setErrorCode(null);
        error.setErrorDescription("An error occurred");

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertNotEquals(error, error1);
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals7() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription("Error Description");

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertNotEquals(error, error1);
    }

    /**
     * Method under test: {@link Error#equals(Object)}
     */
    @Test
    void testEquals8() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription(null);

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription("An error occurred");
        assertNotEquals(error, error1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Error#equals(Object)}
     *   <li>{@link Error#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        Error error = new Error();
        error.setErrorCode(null);
        error.setErrorDescription("An error occurred");

        Error error1 = new Error();
        error1.setErrorCode(null);
        error1.setErrorDescription("An error occurred");
        assertEquals(error, error1);
        int expectedHashCodeResult = error.hashCode();
        assertEquals(expectedHashCodeResult, error1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Error#equals(Object)}
     *   <li>{@link Error#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Error error = new Error();
        error.setErrorCode("An error occurred");
        error.setErrorDescription(null);

        Error error1 = new Error();
        error1.setErrorCode("An error occurred");
        error1.setErrorDescription(null);
        assertEquals(error, error1);
        int expectedHashCodeResult = error.hashCode();
        assertEquals(expectedHashCodeResult, error1.hashCode());
    }
}

