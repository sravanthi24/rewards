package com.retail.rewards.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ApiErrorCodeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ApiErrorCode#valueOf(String)}
     *   <li>{@link ApiErrorCode#getCode()}
     *   <li>{@link ApiErrorCode#getDescription()}
     * </ul>
     */
    @Test
    void testValueOf() {
        ApiErrorCode actualValueOfResult = ApiErrorCode.valueOf("INVALID_PHONENUMBER");
        assertEquals("RETAIL_REWARD_CODE_201", actualValueOfResult.getCode());
        assertEquals("Invalid Phone Number", actualValueOfResult.getDescription());
    }
}

