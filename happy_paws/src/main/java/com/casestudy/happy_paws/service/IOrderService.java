package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<Orders> findAll(Pageable pageable);
}
