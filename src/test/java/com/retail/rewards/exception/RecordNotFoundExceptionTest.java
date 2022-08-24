package com.retail.rewards.exception;

import com.retail.rewards.model.ApiErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordNotFoundExceptionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RecordNotFoundException#RecordNotFoundException(ApiErrorCode)}
     *   <li>{@link RecordNotFoundException#getApiErrorCode()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals(ApiErrorCode.INVALID_PHONENUMBER,
                (new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER)).getApiErrorCode());
    }
}

