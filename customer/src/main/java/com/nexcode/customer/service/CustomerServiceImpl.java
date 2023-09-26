package com.nexcode.customer.service;

import org.springframework.stereotype.Service;

import com.nexcode.customer.model.entity.Customer;
import com.nexcode.customer.model.request.CustomerRequest;
import com.nexcode.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public void registerCustomer(CustomerRequest request) {

		Customer customer = Customer.builder().fullname(request.getFullname()).username(request.getUsername())
				.email(request.getEmail()).build();

		customerRepository.save(customer);

	}

}
