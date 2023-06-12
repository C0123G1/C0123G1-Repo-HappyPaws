package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    boolean save(Product product);
    boolean deleteById(Long id);
    Product findById(Long id);
    List<Product> getAll();
}