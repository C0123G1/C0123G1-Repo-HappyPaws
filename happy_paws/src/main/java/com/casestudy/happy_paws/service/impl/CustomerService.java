package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository ;
    @Override
    public Page<Customer> getAllPage(int page) {
        return customerRepository.findAll(PageRequest.of(page,5));
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
