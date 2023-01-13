package com.retail.rewards.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DetailedRewardPointsResponseTest {
    /**
     * Method under test: {@link DetailedRewardPointsResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new DetailedRewardPointsResponse()).canEqual("Other"));
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertTrue(detailedRewardPointsResponse.canEqual(detailedRewardPointsResponse1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link DetailedRewardPointsResponse}
     *   <li>{@link DetailedRewardPointsResponse#setMonthlyRewardPoints(List)}
     *   <li>{@link DetailedRewardPointsResponse#setTotalRewards(BigDecimal)}
     *   <li>{@link DetailedRewardPointsResponse#toString()}
     *   <li>{@link DetailedRewardPointsResponse#getMonthlyRewardPoints()}
     *   <li>{@link DetailedRewardPointsResponse#getTotalRewards()}
     * </ul>
     */
    @Test
    void testConstructor() {
        DetailedRewardPointsResponse actualDetailedRewardPointsResponse = new DetailedRewardPointsResponse();
        ArrayList<RewardPointsResponse> rewardPointsResponseList = new ArrayList<>();
        actualDetailedRewardPointsResponse.setMonthlyRewardPoints(rewardPointsResponseList);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualDetailedRewardPointsResponse.setTotalRewards(valueOfResult);
        String actualToStringResult = actualDetailedRewardPointsResponse.toString();
        assertSame(rewardPointsResponseList, actualDetailedRewardPointsResponse.getMonthlyRewardPoints());
        assertSame(valueOfResult, actualDetailedRewardPointsResponse.getTotalRewards());
        assertEquals("DetailedRewardPointsResponse(totalRewards=42, monthlyRewardPoints=[])", actualToStringResult);
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, null);
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals2() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, "Different type to DetailedRewardPointsResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DetailedRewardPointsResponse#equals(Object)}
     *   <li>{@link DetailedRewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));
        assertEquals(detailedRewardPointsResponse, detailedRewardPointsResponse);
        int expectedHashCodeResult = detailedRewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, detailedRewardPointsResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DetailedRewardPointsResponse#equals(Object)}
     *   <li>{@link DetailedRewardPointsResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertEquals(detailedRewardPointsResponse, detailedRewardPointsResponse1);
        int expectedHashCodeResult = detailedRewardPointsResponse.hashCode();
        assertEquals(expectedHashCodeResult, detailedRewardPointsResponse1.hashCode());
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        RewardPointsResponse rewardPointsResponse = new RewardPointsResponse();
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        ArrayList<RewardPointsResponse> rewardPointsResponseList = new ArrayList<>();
        rewardPointsResponseList.add(rewardPointsResponse);

        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(rewardPointsResponseList);
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, detailedRewardPointsResponse1);
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(1L));

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, detailedRewardPointsResponse1);
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse.setTotalRewards(null);

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, detailedRewardPointsResponse1);
    }

    /**
     * Method under test: {@link DetailedRewardPointsResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        RewardPointsResponse rewardPointsResponse = mock(RewardPointsResponse.class);
        doNothing().when(rewardPointsResponse).setMonthYear((String) any());
        doNothing().when(rewardPointsResponse).setRewardPoints((BigDecimal) any());
        rewardPointsResponse.setMonthYear("Month Year");
        rewardPointsResponse.setRewardPoints(BigDecimal.valueOf(42L));

        ArrayList<RewardPointsResponse> rewardPointsResponseList = new ArrayList<>();
        rewardPointsResponseList.add(rewardPointsResponse);

        DetailedRewardPointsResponse detailedRewardPointsResponse = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse.setMonthlyRewardPoints(rewardPointsResponseList);
        detailedRewardPointsResponse.setTotalRewards(BigDecimal.valueOf(42L));

        DetailedRewardPointsResponse detailedRewardPointsResponse1 = new DetailedRewardPointsResponse();
        detailedRewardPointsResponse1.setMonthlyRewardPoints(new ArrayList<>());
        detailedRewardPointsResponse1.setTotalRewards(BigDecimal.valueOf(42L));
        assertNotEquals(detailedRewardPointsResponse, detailedRewardPointsResponse1);
    }
}

