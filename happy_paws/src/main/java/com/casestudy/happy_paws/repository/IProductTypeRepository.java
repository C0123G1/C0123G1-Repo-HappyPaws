package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<Product, Long> {
}
