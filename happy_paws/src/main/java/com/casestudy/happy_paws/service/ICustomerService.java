package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.dto.CustomerDTO;
import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> getAllPage(int page);

    void save(Customer customer);

    Customer findById(Integer customerId);

    void update(Customer customer);

    void delete(Integer customerId);
    int getRandom(int min, int max) ;

    Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable);
}
