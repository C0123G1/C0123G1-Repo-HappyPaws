package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
