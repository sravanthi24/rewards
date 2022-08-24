package com.retail.rewards.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAllRewardPointsTest {
    /**
     * Method under test: {@link GetAllRewardPoints#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new GetAllRewardPoints()).canEqual("Other"));
    }

    /**
     * Method under test: {@link GetAllRewardPoints#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertTrue(getAllRewardPoints.canEqual(getAllRewardPoints1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link GetAllRewardPoints}
     *   <li>{@link GetAllRewardPoints#setPhoneNumber(String)}
     *   <li>{@link GetAllRewardPoints#setRewardPoints(String)}
     *   <li>{@link GetAllRewardPoints#toString()}
     *   <li>{@link GetAllRewardPoints#getPhoneNumber()}
     *   <li>{@link GetAllRewardPoints#getRewardPoints()}
     * </ul>
     */
    @Test
    void testConstructor() {
        GetAllRewardPoints actualGetAllRewardPoints = new GetAllRewardPoints();
        actualGetAllRewardPoints.setPhoneNumber("4105551212");
        actualGetAllRewardPoints.setRewardPoints("Reward Points");
        String actualToStringResult = actualGetAllRewardPoints.toString();
        assertEquals("4105551212", actualGetAllRewardPoints.getPhoneNumber());
        assertEquals("Reward Points", actualGetAllRewardPoints.getRewardPoints());
        assertEquals("GetAllRewardPoints(phoneNumber=4105551212, rewardPoints=Reward Points)", actualToStringResult);
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, null);
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals2() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, "Different type to GetAllRewardPoints");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GetAllRewardPoints#equals(Object)}
     *   <li>{@link GetAllRewardPoints#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("Reward Points");
        assertEquals(getAllRewardPoints, getAllRewardPoints);
        int expectedHashCodeResult = getAllRewardPoints.hashCode();
        assertEquals(expectedHashCodeResult, getAllRewardPoints.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GetAllRewardPoints#equals(Object)}
     *   <li>{@link GetAllRewardPoints#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("Reward Points");

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertEquals(getAllRewardPoints, getAllRewardPoints1);
        int expectedHashCodeResult = getAllRewardPoints.hashCode();
        assertEquals(expectedHashCodeResult, getAllRewardPoints1.hashCode());
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals5() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("+44 1865 4960636");
        getAllRewardPoints.setRewardPoints("Reward Points");

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, getAllRewardPoints1);
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals6() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber(null);
        getAllRewardPoints.setRewardPoints("Reward Points");

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, getAllRewardPoints1);
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals7() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints("4105551212");

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, getAllRewardPoints1);
    }

    /**
     * Method under test: {@link GetAllRewardPoints#equals(Object)}
     */
    @Test
    void testEquals8() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints(null);

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertNotEquals(getAllRewardPoints, getAllRewardPoints1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GetAllRewardPoints#equals(Object)}
     *   <li>{@link GetAllRewardPoints#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber(null);
        getAllRewardPoints.setRewardPoints("Reward Points");

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber(null);
        getAllRewardPoints1.setRewardPoints("Reward Points");
        assertEquals(getAllRewardPoints, getAllRewardPoints1);
        int expectedHashCodeResult = getAllRewardPoints.hashCode();
        assertEquals(expectedHashCodeResult, getAllRewardPoints1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GetAllRewardPoints#equals(Object)}
     *   <li>{@link GetAllRewardPoints#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        GetAllRewardPoints getAllRewardPoints = new GetAllRewardPoints();
        getAllRewardPoints.setPhoneNumber("4105551212");
        getAllRewardPoints.setRewardPoints(null);

        GetAllRewardPoints getAllRewardPoints1 = new GetAllRewardPoints();
        getAllRewardPoints1.setPhoneNumber("4105551212");
        getAllRewardPoints1.setRewardPoints(null);
        assertEquals(getAllRewardPoints, getAllRewardPoints1);
        int expectedHashCodeResult = getAllRewardPoints.hashCode();
        assertEquals(expectedHashCodeResult, getAllRewardPoints1.hashCode());
    }
}

