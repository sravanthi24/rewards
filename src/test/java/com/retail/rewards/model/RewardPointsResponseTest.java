package com.retail.rewards.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class RewardPointsResponseTest {
    /**
     * Method under test: {@link RewardPointsResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new RewardPointsResponse()).canEqual("Other"));
    }

    /**
     * Method under test: {@link RewardPointsResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertTrue(rewardPointsResponse.canEqual(rewardPointsResponse1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RewardPointsResponse}
     *   <li>{@link RewardPointsResponse#setMonthYear(String)}
     *   <li>{@link RewardPointsResponse#setRewardPoints(BigDecimal)}
     *   <li>{@link RewardPointsResponse#toString()}
     *   <li>{@link RewardPointsResponse#getMonthYear()}
     *   <li>{@link RewardPointsResponse#getRewardPoints()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RewardPointsResponse actualRewardPointsResponse = new RewardPointsResponse();
        actualRewardPointsResponse.setMonthYear("Month Year");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualRewardPointsResponse.setRewardPoints(valueOfResult);
        String actualToStringResult = actualRewardPointsResponse.toString();
        assertEquals("Month Year", actualRewardPointsResponse.getMonthYear());
        assertSame(valueOfResult, actualRewardPointsResponse.getRewardPoints());
        assertEquals("RewardPointsResponse(monthYear=Month Year, rewardPoints=42)", actualToStringResult);
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, null);
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals2() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, "Different type to RewardPointsResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPointsResponse#equals(Object)}
     *   <li>{@link RewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));
        assertEquals(rewardPointsResponse, rewardPointsResponse);
        int expectedHashCodeResult = rewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, rewardPointsResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPointsResponse#equals(Object)}
     *   <li>{@link RewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertEquals(rewardPointsResponse, rewardPointsResponse1);
        int expectedHashCodeResult = rewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, rewardPointsResponse1.hashCode());
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear(null);
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, rewardPointsResponse1);
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("com.retail.rewards.model.RewardPointsResponse");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, rewardPointsResponse1);
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(1L));

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, rewardPointsResponse1);
    }

    /**
     * Method under test: {@link RewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(null);

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertNotEquals(rewardPointsResponse, rewardPointsResponse1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPointsResponse#equals(Object)}
     *   <li>{@link RewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear(null);
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear(null);
        rewardPointsResponse1.setRewardPoints(BigDecimal.valueOf(42L));
        assertEquals(rewardPointsResponse, rewardPointsResponse1);
        int expectedHashCodeResult = rewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, rewardPointsResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPointsResponse#equals(Object)}
     *   <li>{@link RewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(null);

        RewardPointsResponse rewardPointsResponse1 = new RewardPointsResponse();
        rewardPointsResponse1.setMonthYear("Month Year");
        rewardPointsResponse1.setRewardPoints(null);
        assertEquals(rewardPointsResponse, rewardPointsResponse1);
        int expectedHashCodeResult = rewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, rewardPointsResponse1.hashCode());
    }
}

