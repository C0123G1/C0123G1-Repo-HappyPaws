package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.repository.ICustomerRepository;
import com.casestudy.happy_paws.repository.IOrderRepository;
import com.casestudy.happy_paws.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }
    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public boolean saveOrder(Orders orders) {
        try{
            iOrderRepository.save(orders);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Page<Orders> searchByNameAndPhone(String name, String phone,Pageable pageable) {
        return iOrderRepository.searchByNameAndPhone('%' + name + '%', '%' +phone + '%',pageable);
    }

    @Override
    public Page<Customer> searchCustomerByNameAndPhone(String name, String phone, Pageable pageable) {
        return iOrderRepository.searchCustomerByNameAndPhone('%' + name + '%', '%' +phone + '%',pageable);
    }
}
