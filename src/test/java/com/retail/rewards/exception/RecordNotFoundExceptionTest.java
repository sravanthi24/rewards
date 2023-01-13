package com.retail.rewards.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.retail.rewards.model.ApiErrorCode;
import org.junit.jupiter.api.Test;

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

