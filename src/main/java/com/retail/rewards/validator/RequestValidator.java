package com.retail.rewards.validator;


import com.retail.rewards.model.ApiErrorCode;
import com.retail.rewards.model.CreateTransactionRequest;
import com.retail.rewards.model.Error;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestValidator {

    public List<Error> createRequestValidator(CreateTransactionRequest request){
        List<Error> errorList = new ArrayList<>();
        validatePhoneNumber(request.getPhoneNumber(), errorList);
        validateTransactionAmount(request.getBillAmount(),errorList);
        Error error = null;
        if(StringUtils.isBlank(request.getName())) {
            error = new Error();
            error.setErrorCode(ApiErrorCode.MISSING_NAME.getCode());
            error.setErrorDescription(ApiErrorCode.MISSING_NAME.getDescription());
            errorList.add(error);
        }

        if(request.getTransactionDate() == null) {
            error = new Error();
            error.setErrorCode(ApiErrorCode.MISSING_TRANSACTION_DATE.getCode());
            error.setErrorDescription(ApiErrorCode.MISSING_TRANSACTION_DATE.getDescription());
            errorList.add(error);

        }
        return errorList;
    }

    public void validatePhoneNumber(String number,List<Error> errorList ){
        Error error = null;
        if(StringUtils.isBlank(number)){
            error = new Error();
            error.setErrorCode(ApiErrorCode.MISSING_PHONE_NUMBER.getCode());
            error.setErrorDescription(ApiErrorCode.MISSING_PHONE_NUMBER.getDescription());
            errorList.add(error);
        }
        else if(!number.matches("[0-9]+")){
            error = new Error();
            error.setErrorCode(ApiErrorCode.INVALID_PHONENUMBER.getCode());
            error.setErrorDescription(ApiErrorCode.INVALID_PHONENUMBER.getDescription());
            errorList.add(error);
        }
    }

    public void validateTransactionAmount(Double amount,List<Error> errorList){
        Error error = null;
        if(amount == null) {
            error = new Error();
            error.setErrorCode(ApiErrorCode.MISSING_AMOUNT.getCode());
            error.setErrorDescription(ApiErrorCode.MISSING_AMOUNT.getDescription());
            errorList.add(error);
        }

    }

}
