package com.nexcode.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nexcode.customer.model.entity.Customer;
import com.nexcode.customer.model.request.CustomerRequest;
import com.nexcode.customer.model.response.FraudCheckResponse;
import com.nexcode.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private final RestTemplate restTemplate;

	@Override
	public void registerCustomer(CustomerRequest request) {

		Customer customer = Customer.builder().fullname(request.getFullname()).username(request.getUsername())
				.email(request.getEmail()).build();

		customerRepository.saveAndFlush(customer);

		FraudCheckResponse response = restTemplate.getForObject("http://localhost:8082/api/v1/fraud/{id}/check",
				FraudCheckResponse.class, customer.getId());

		if (response.isFraud()) {
			System.out.println(response.isFraud());
			System.out.println("Error");
		}

	}

}
