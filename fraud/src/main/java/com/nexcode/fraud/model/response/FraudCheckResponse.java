package com.nexcode.fraud.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FraudCheckResponse {

	private boolean fraud;

	public FraudCheckResponse(boolean fraud) {
		this.fraud = fraud;
	}

	public FraudCheckResponse() {
	}

}
