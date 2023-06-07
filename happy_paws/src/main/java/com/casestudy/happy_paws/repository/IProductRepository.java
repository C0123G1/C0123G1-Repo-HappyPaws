package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.awt.print.Pageable;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "update product set is_delete = true where id=:id",nativeQuery = true)
    @Modifying
    @Transactional
    void deletebyId(@Param("id") Long id);
    @Query(value = "select p from Product p where p.isDelete = false")
    Page<Product> findAllSupplies(Pageable pageable);
}

