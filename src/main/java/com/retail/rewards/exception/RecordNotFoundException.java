package com.retail.rewards.exception;

import com.retail.rewards.model.ApiErrorCode;

public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ApiErrorCode apiErrorCode;

	public RecordNotFoundException(ApiErrorCode apiErrorCode) {
		super();
		this.apiErrorCode = apiErrorCode;
	}

	public ApiErrorCode getApiErrorCode() {
		return apiErrorCode;
	}
}
