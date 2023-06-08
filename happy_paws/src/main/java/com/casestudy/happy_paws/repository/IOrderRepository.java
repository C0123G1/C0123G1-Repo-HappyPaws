package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select o from Orders o where o.customer.name like :name and o.customer.phone like :phone")
    Page<Orders> searchByNameAndPhone(@Param("name") String name, @Param("phone")String phone, Pageable pageable);
    @Query(value = "select c from Customer c where c.name like :name and c.phone like :phone")
    Page<Customer> searchCustomerByNameAndPhone(@Param("name") String name, @Param("phone")String phone, Pageable pageable);
}
