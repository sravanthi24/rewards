package com.retail.rewards.model;

public enum ApiErrorCode {

	INVALID_PHONENUMBER("RETAIL_REWARD_CODE_201", "Invalid Phone Number"),
	INVALID_AMOUNT("RETAIL_REWARD_CODE_203", "Invalid Amount"),
	MISSING_TRANSACTION_DATE("RETAIL_REWARD_CODE_204", "Transaction Date is Missing"),
	MISSING_NAME("RETAIL_REWARD_CODE_202", "Name is Missing"),

	TRANSACTION_NOT_FOUND_REQUEST("RETAIL_REWARD_CODE_204", "Transaction Not Found"),
	POINTS_NOT_FOUND_REQ_PHONE("RETAIL_REWARD_CODE_205", "No reward points found for phone-number"),
	POINTS_NOT_FOUND_REQ_MONTH("RETAIL_REWARD_CODE_206", "No reward points found for phone-number for past months"),
	CUSTOMER_NOT_FOUND_REQUEST("RETAIL_REWARD_CODE_207", "No Customers Found"),
	MISSING_PHONE_NUMBER("RETAIL_REWARD_CODE_208", "Phone Number is Missing"),
	MISSING_AMOUNT("RETAIL_REWARD_CODE_209", "Amount is Missing"),

	INVALID_PHONENUMBER_LENGTH("RETAIL_REWARD_CODE_210", "Length of Phone Number should be more than 3 and less than 15");

	private final String code;
	private final String description;

	ApiErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
