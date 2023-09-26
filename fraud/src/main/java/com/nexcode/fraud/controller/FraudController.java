package com.nexcode.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.fraud.model.response.FraudCheckResponse;
import com.nexcode.fraud.service.FraudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

	private final FraudService fraudService;

	@GetMapping("/{id}/check")
	public FraudCheckResponse check(@PathVariable Long id) {

		boolean isFraudulentCustomer = fraudService.isFraudlentCustomer(id);

		return new FraudCheckResponse(isFraudulentCustomer);
	}

}
