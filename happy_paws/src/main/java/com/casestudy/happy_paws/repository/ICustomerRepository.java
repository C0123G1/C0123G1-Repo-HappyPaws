package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
