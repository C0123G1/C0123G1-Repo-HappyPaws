package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Page<Customer> getAllPage(int page);

    void save(Customer customer);

    Customer findById(Integer id);

    void update(Customer customer);
}
