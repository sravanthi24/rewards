package com.retail.rewards.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.Error;

import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class RetailExceptionHandlerTest {
    /**
     * Method under test: {@link RetailExceptionHandler#exception(RecordNotFoundException)}
     */
    @Test
    void testException() {
        RetailExceptionHandler retailExceptionHandler = new RetailExceptionHandler();
        ResponseEntity<List<Error>> actualExceptionResult = retailExceptionHandler
                .exception(new RecordNotFoundException(ApiErrorCode.INVALID_PHONENUMBER));
        List<Error> body = actualExceptionResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualExceptionResult.hasBody());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualExceptionResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_201", getResult.getErrorCode());
        assertEquals("Invalid Phone Number", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#handleAllExceptions(Exception)}
     */
    @Test
    void testHandleAllExceptions() {
        RetailExceptionHandler retailExceptionHandler = new RetailExceptionHandler();
        ResponseEntity<Object> actualHandleAllExceptionsResult = retailExceptionHandler
                .handleAllExceptions(new Exception("An error occurred"));
        assertEquals("Sorry something went wrong please try after sometime", actualHandleAllExceptionsResult.getBody());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleAllExceptionsResult.getStatusCode());
        assertTrue(actualHandleAllExceptionsResult.getHeaders().isEmpty());
    }
    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.INVALID_PHONENUMBER, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_201", getResult.getErrorCode());
        assertEquals("Invalid Phone Number", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse2() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.INVALID_AMOUNT, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_203", getResult.getErrorCode());
        assertEquals("Invalid Amount", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse3() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.MISSING_TRANSACTION_DATE, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_204", getResult.getErrorCode());
        assertEquals("Transaction Date is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse4() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.MISSING_NAME, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_202", getResult.getErrorCode());
        assertEquals("Name is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse5() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.TRANSACTION_NOT_FOUND_REQUEST, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_204", getResult.getErrorCode());
        assertEquals("Transaction Not Found", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse6() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.POINTS_NOT_FOUND_REQ_PHONE, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_205", getResult.getErrorCode());
        assertEquals("No reward points found for phone-number", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse7() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.POINTS_NOT_FOUND_REQ_MONTH, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_206", getResult.getErrorCode());
        assertEquals("No reward points found for phone-number for past months", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse8() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.CUSTOMER_NOT_FOUND_REQUEST, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_207", getResult.getErrorCode());
        assertEquals("No Customers Found", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse9() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.MISSING_PHONE_NUMBER, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_208", getResult.getErrorCode());
        assertEquals("Phone Number is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse10() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.MISSING_AMOUNT, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_209", getResult.getErrorCode());
        assertEquals("Amount is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RetailExceptionHandler#generateClientResponse(ApiErrorCode, HttpStatus)}
     */
    @Test
    void testGenerateClientResponse11() {
        ResponseEntity<List<Error>> actualGenerateClientResponseResult = (new RetailExceptionHandler())
                .generateClientResponse(ApiErrorCode.INVALID_PHONENUMBER_LENGTH, HttpStatus.CONTINUE);
        List<Error> body = actualGenerateClientResponseResult.getBody();
        assertEquals(1, body.size());
        assertTrue(actualGenerateClientResponseResult.hasBody());
        assertTrue(actualGenerateClientResponseResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CONTINUE, actualGenerateClientResponseResult.getStatusCode());
        Error getResult = body.get(0);
        assertEquals("RETAIL_REWARD_CODE_210", getResult.getErrorCode());
        assertEquals("Length of Phone Number should be more than 3 and less than 15", getResult.getErrorDescription());
    }
}

