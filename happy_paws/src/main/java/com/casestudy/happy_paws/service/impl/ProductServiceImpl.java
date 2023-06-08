package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
