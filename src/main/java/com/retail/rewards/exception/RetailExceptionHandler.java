package com.retail.rewards.exception;

import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RetailExceptionHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<List<Error>> exception(RecordNotFoundException ex) {
        ApiErrorCode apiErrorCode = ex.getApiErrorCode();
        return generateClientResponse(apiErrorCode,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage() +" Sorry something went wrong please try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Error>> generateClientResponse(ApiErrorCode apiError,HttpStatus status){
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        error.setErrorCode(apiError.getCode());
        error.setErrorDescription(apiError.getDescription());
        errors.add(error);
        return new ResponseEntity<>(errors,status);

    }
}
