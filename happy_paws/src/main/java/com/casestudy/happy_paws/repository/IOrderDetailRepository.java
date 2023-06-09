package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.OrderDetail;
import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select od from OrderDetail od where od.order.id = :orderId and od.idDelete = false ")
    Page<OrderDetail> findAllOrderDetailByOrderId(Pageable pageable, @Param("orderId") Long orderId);
    @Query(value = "select od from OrderDetail  od where od.products.name like :name and od.order.id= :orderId and od.idDelete = false")
    Page<OrderDetail> searchProductOrderDetail(@Param("name") String name,@Param("orderId") Long orderId, Pageable pageable);
    @Query(value = "select sum(od.price * od.quantity) from  OrderDetail  od where od.order.id = :orderId and od.idDelete = false")
    Double getTotalPriceOrder(@Param("orderId") Long orderId);
    @Query(value = "update OrderDetail set idDelete = true where id = :orderDetailId")
    @Modifying
    @Transactional
    void deleteOrderDetailById(@Param("orderDetailId") Long orderDetailId);
}
