package com.nexcode.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexcode.fraud.model.entity.FraudCheckHistory;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Long> {

}
