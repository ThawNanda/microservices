package com.nexcode.fraud.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.nexcode.fraud.model.entity.FraudCheckHistory;
import com.nexcode.fraud.repository.FraudRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {

	private final FraudRepository fraudRepository;

	@Override
	public boolean isFraudlentCustomer(Long id) {

		FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().customerId(id).isFraudster(false)
				.createdAt(LocalDateTime.now()).build();

		fraudRepository.save(fraudCheckHistory);

		return false;
	}

}
