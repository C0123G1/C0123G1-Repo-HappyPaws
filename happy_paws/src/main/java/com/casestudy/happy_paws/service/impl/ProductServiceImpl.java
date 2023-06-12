package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.repository.IProductRepository;
import com.casestudy.happy_paws.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

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

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }
}
