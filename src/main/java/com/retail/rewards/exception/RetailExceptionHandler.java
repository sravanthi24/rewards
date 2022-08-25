package com.retail.rewards.exception;

import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class RetailExceptionHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<List<Error>> exception(RecordNotFoundException ex) {
        ApiErrorCode apiErrorCode = ex.getApiErrorCode();
        return generateClientResponse(apiErrorCode,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        log.info("Exception "+ ex.getMessage());
        return new ResponseEntity<>("Sorry something went wrong please try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
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
