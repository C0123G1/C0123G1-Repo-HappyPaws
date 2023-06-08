package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.OrderDetail;
import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select od from OrderDetail od where od.order.id = :orderId")
    Page<OrderDetail> findAllOrderDetailByOrderId(Pageable pageable, @Param("orderId") Long orderId);
    @Query(value = "select od from OrderDetail  od where od.products.name like :name and od.id= :orderId")
    Page<Product> searchProductOrderDetail(@Param("name") String name,@Param("orderId") Long orderId, Pageable pageable);
}
