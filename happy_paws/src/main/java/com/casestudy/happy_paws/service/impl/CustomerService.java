package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAllPage(int page) {
        return customerRepository.findAllCustomer(PageRequest.of(page, 5));
    }


    @Transactional(rollbackOn = Throwable.class)
    @Override
    public boolean save(Customer customer) {
        List<Customer> customerList = customerRepository.findAll();
        for (int i = 0; i <customerList.size() ; i++) {
            if(customer.getEmail().equals(customerList.get(i).getEmail()) || customer.getPhone().equals(customerList.get(i).getPhone()) ){
                return false;
            }
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        customerRepository.deleteByIdCustomer(customerId);
    }

    public int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable) {
        return customerRepository.findByCustomer(name, phone, username, pageable);

    }
}
