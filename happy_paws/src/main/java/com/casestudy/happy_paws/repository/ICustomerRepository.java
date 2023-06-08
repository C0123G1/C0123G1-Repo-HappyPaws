package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {


    @Query(value = "SELECT c.* FROM customer c INNER JOIN account u ON u.account_id = c.account_id  WHERE  c.name LIKE :name AND c.phone LIKE  :phone AND u.username  LIKE :username  ",nativeQuery = true)
    Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable);
}
