package com.retail.rewards.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.retail.rewards.model.CreateTransactionRequest;
import com.retail.rewards.model.Error;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RequestValidator.class})
@ExtendWith(SpringExtension.class)
class RequestValidatorTest {
    @Autowired
    private RequestValidator requestValidator;

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertTrue(requestValidator.createRequestValidator(createTransactionRequest).isEmpty());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator2() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("4105551212");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertTrue(requestValidator.createRequestValidator(createTransactionRequest).isEmpty());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator3() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn(null);
        when(createTransactionRequest.getPhoneNumber()).thenReturn("4105551212");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        List<Error> actualCreateRequestValidatorResult = requestValidator
                .createRequestValidator(createTransactionRequest);
        assertEquals(1, actualCreateRequestValidatorResult.size());
        Error getResult = actualCreateRequestValidatorResult.get(0);
        assertEquals("RETAIL_REWARD_CODE_202", getResult.getErrorCode());
        assertEquals("Name is Missing", getResult.getErrorDescription());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator4() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("9");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertTrue(requestValidator.createRequestValidator(createTransactionRequest).isEmpty());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator5() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("[0-9]+");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        List<Error> actualCreateRequestValidatorResult = requestValidator
                .createRequestValidator(createTransactionRequest);
        assertEquals(1, actualCreateRequestValidatorResult.size());
        Error getResult = actualCreateRequestValidatorResult.get(0);
        assertEquals("RETAIL_REWARD_CODE_201", getResult.getErrorCode());
        assertEquals("Invalid Phone Number", getResult.getErrorDescription());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator6() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn(null);
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        List<Error> actualCreateRequestValidatorResult = requestValidator
                .createRequestValidator(createTransactionRequest);
        assertEquals(1, actualCreateRequestValidatorResult.size());
        Error getResult = actualCreateRequestValidatorResult.get(0);
        assertEquals("RETAIL_REWARD_CODE_208", getResult.getErrorCode());
        assertEquals("Phone Number is Missing", getResult.getErrorDescription());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator7() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("42");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        assertTrue(requestValidator.createRequestValidator(createTransactionRequest).isEmpty());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator8() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("4105551212");
        when(createTransactionRequest.getBillAmount()).thenReturn(null);
        when(createTransactionRequest.getTransactionDate()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        List<Error> actualCreateRequestValidatorResult = requestValidator
                .createRequestValidator(createTransactionRequest);
        assertEquals(1, actualCreateRequestValidatorResult.size());
        Error getResult = actualCreateRequestValidatorResult.get(0);
        assertEquals("RETAIL_REWARD_CODE_209", getResult.getErrorCode());
        assertEquals("Amount is Missing", getResult.getErrorDescription());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#createRequestValidator(CreateTransactionRequest)}
     */
    @Test
    void testCreateRequestValidator9() {
        CreateTransactionRequest createTransactionRequest = mock(CreateTransactionRequest.class);
        when(createTransactionRequest.getName()).thenReturn("Name");
        when(createTransactionRequest.getPhoneNumber()).thenReturn("4105551212");
        when(createTransactionRequest.getBillAmount()).thenReturn(BigDecimal.valueOf(42L));
        when(createTransactionRequest.getTransactionDate()).thenReturn(null);
        doNothing().when(createTransactionRequest).setBillAmount((BigDecimal) any());
        doNothing().when(createTransactionRequest).setName((String) any());
        doNothing().when(createTransactionRequest).setPhoneNumber((String) any());
        doNothing().when(createTransactionRequest).setTransactionDate((LocalDate) any());
        createTransactionRequest.setBillAmount(BigDecimal.valueOf(42L));
        createTransactionRequest.setName("Name");
        createTransactionRequest.setPhoneNumber("4105551212");
        createTransactionRequest.setTransactionDate(LocalDate.ofEpochDay(1L));
        List<Error> actualCreateRequestValidatorResult = requestValidator
                .createRequestValidator(createTransactionRequest);
        assertEquals(1, actualCreateRequestValidatorResult.size());
        Error getResult = actualCreateRequestValidatorResult.get(0);
        assertEquals("RETAIL_REWARD_CODE_204", getResult.getErrorCode());
        assertEquals("Transaction Date is Missing", getResult.getErrorDescription());
        verify(createTransactionRequest).getName();
        verify(createTransactionRequest).getPhoneNumber();
        verify(createTransactionRequest).getBillAmount();
        verify(createTransactionRequest).getTransactionDate();
        verify(createTransactionRequest).setBillAmount((BigDecimal) any());
        verify(createTransactionRequest).setName((String) any());
        verify(createTransactionRequest).setPhoneNumber((String) any());
        verify(createTransactionRequest).setTransactionDate((LocalDate) any());
    }

    /**
     * Method under test: {@link RequestValidator#validatePhoneNumber(String, List)}
     */
    @Test
    void testValidatePhoneNumber() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by validatePhoneNumber(String, List)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        requestValidator.validatePhoneNumber("42", new ArrayList<>());
    }

    /**
     * Method under test: {@link RequestValidator#validatePhoneNumber(String, List)}
     */
    @Test
    void testValidatePhoneNumber2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by validatePhoneNumber(String, List)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        requestValidator.validatePhoneNumber("9", new ArrayList<>());
    }

    /**
     * Method under test: {@link RequestValidator#validatePhoneNumber(String, List)}
     */
    @Test
    void testValidatePhoneNumber3() {
        ArrayList<Error> errorList = new ArrayList<>();
        requestValidator.validatePhoneNumber("[0-9]+", errorList);
        assertEquals(1, errorList.size());
        Error getResult = errorList.get(0);
        assertEquals("RETAIL_REWARD_CODE_201", getResult.getErrorCode());
        assertEquals("Invalid Phone Number", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RequestValidator#validatePhoneNumber(String, List)}
     */
    @Test
    void testValidatePhoneNumber4() {
        ArrayList<Error> errorList = new ArrayList<>();
        requestValidator.validatePhoneNumber("", errorList);
        assertEquals(1, errorList.size());
        Error getResult = errorList.get(0);
        assertEquals("RETAIL_REWARD_CODE_208", getResult.getErrorCode());
        assertEquals("Phone Number is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RequestValidator#validatePhoneNumber(String, List)}
     */
    @Test
    void testValidatePhoneNumber5() {
        Error error = mock(Error.class);
        doNothing().when(error).setErrorCode((String) any());
        doNothing().when(error).setErrorDescription((String) any());
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");

        ArrayList<Error> errorList = new ArrayList<>();
        errorList.add(error);
        requestValidator.validatePhoneNumber("42", errorList);
        verify(error).setErrorCode((String) any());
        verify(error).setErrorDescription((String) any());
    }

    /**
     * Method under test: {@link RequestValidator#validateTransactionAmount(BigDecimal, List)}
     */
    @Test
    void testValidateTransactionAmount() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by validateTransactionAmount(BigDecimal, List)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BigDecimal amount = BigDecimal.valueOf(42L);
        requestValidator.validateTransactionAmount(amount, new ArrayList<>());
    }

    /**
     * Method under test: {@link RequestValidator#validateTransactionAmount(BigDecimal, List)}
     */
    @Test
    void testValidateTransactionAmount2() {
        ArrayList<Error> errorList = new ArrayList<>();
        requestValidator.validateTransactionAmount(null, errorList);
        assertEquals(1, errorList.size());
        Error getResult = errorList.get(0);
        assertEquals("RETAIL_REWARD_CODE_209", getResult.getErrorCode());
        assertEquals("Amount is Missing", getResult.getErrorDescription());
    }

    /**
     * Method under test: {@link RequestValidator#validateTransactionAmount(BigDecimal, List)}
     */
    @Test
    void testValidateTransactionAmount3() {
        BigDecimal amount = BigDecimal.valueOf(42L);
        Error error = mock(Error.class);
        doNothing().when(error).setErrorCode((String) any());
        doNothing().when(error).setErrorDescription((String) any());
        error.setErrorCode("An error occurred");
        error.setErrorDescription("An error occurred");

        ArrayList<Error> errorList = new ArrayList<>();
        errorList.add(error);
        requestValidator.validateTransactionAmount(amount, errorList);
        verify(error).setErrorCode((String) any());
        verify(error).setErrorDescription((String) any());
    }
}

