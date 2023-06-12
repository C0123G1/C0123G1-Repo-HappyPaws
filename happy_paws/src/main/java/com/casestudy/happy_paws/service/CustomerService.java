package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.service.impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
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
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
