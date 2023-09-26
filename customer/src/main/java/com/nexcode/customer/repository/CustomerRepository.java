package com.nexcode.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexcode.customer.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
