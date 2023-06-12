package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders, Long> {
}
