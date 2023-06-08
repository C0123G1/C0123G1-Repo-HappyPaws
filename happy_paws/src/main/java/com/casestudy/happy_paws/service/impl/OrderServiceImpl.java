package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.repository.IOrderRepository;
import com.casestudy.happy_paws.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }
}
