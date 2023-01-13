package com.retail.rewards.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class RewardPointTest {
    /**
     * Method under test: {@link RewardPoint#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new RewardPoint()).canEqual("Other"));
    }

    /**
     * Method under test: {@link RewardPoint#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        RewardPoint rewardPoint = new RewardPoint();

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(3);
        assertTrue(rewardPoint.canEqual(rewardPoint1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RewardPoint}
     *   <li>{@link RewardPoint#setAmountLimit(BigDecimal)}
     *   <li>{@link RewardPoint#setId(int)}
     *   <li>{@link RewardPoint#setPoints(Integer)}
     *   <li>{@link RewardPoint#toString()}
     *   <li>{@link RewardPoint#getAmountLimit()}
     *   <li>{@link RewardPoint#getId()}
     *   <li>{@link RewardPoint#getPoints()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RewardPoint actualRewardPoint = new RewardPoint();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualRewardPoint.setAmountLimit(valueOfResult);
        actualRewardPoint.setId(123);
        actualRewardPoint.setPoints(1);
        String actualToStringResult = actualRewardPoint.toString();
        assertSame(valueOfResult, actualRewardPoint.getAmountLimit());
        assertEquals(123, actualRewardPoint.getId());
        assertEquals(1, actualRewardPoint.getPoints().intValue());
        assertEquals("RewardPoint(amountLimit=42, points=1, Id=123)", actualToStringResult);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);
        assertNotEquals(rewardPoint, null);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals2() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);
        assertNotEquals(rewardPoint, "Different type to RewardPoint");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPoint#equals(Object)}
     *   <li>{@link RewardPoint#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);
        assertEquals(rewardPoint, rewardPoint);
        int expectedHashCodeResult = rewardPoint.hashCode();
        assertEquals(expectedHashCodeResult, rewardPoint.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPoint#equals(Object)}
     *   <li>{@link RewardPoint#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertEquals(rewardPoint, rewardPoint1);
        int expectedHashCodeResult = rewardPoint.hashCode();
        assertEquals(expectedHashCodeResult, rewardPoint1.hashCode());
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals5() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(1L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertNotEquals(rewardPoint, rewardPoint1);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals6() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(null);
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertNotEquals(rewardPoint, rewardPoint1);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals7() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(1);
        rewardPoint.setPoints(1);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertNotEquals(rewardPoint, rewardPoint1);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals8() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(3);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertNotEquals(rewardPoint, rewardPoint1);
    }

    /**
     * Method under test: {@link RewardPoint#equals(Object)}
     */
    @Test
    void testEquals9() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(null);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertNotEquals(rewardPoint, rewardPoint1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPoint#equals(Object)}
     *   <li>{@link RewardPoint#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(null);
        rewardPoint.setId(123);
        rewardPoint.setPoints(1);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(null);
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(1);
        assertEquals(rewardPoint, rewardPoint1);
        int expectedHashCodeResult = rewardPoint.hashCode();
        assertEquals(expectedHashCodeResult, rewardPoint1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RewardPoint#equals(Object)}
     *   <li>{@link RewardPoint#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint.setId(123);
        rewardPoint.setPoints(null);

        RewardPoint rewardPoint1 = new RewardPoint();
        rewardPoint1.setAmountLimit(BigDecimal.valueOf(42L));
        rewardPoint1.setId(123);
        rewardPoint1.setPoints(null);
        assertEquals(rewardPoint, rewardPoint1);
        int expectedHashCodeResult = rewardPoint.hashCode();
        assertEquals(expectedHashCodeResult, rewardPoint1.hashCode());
    }
}

