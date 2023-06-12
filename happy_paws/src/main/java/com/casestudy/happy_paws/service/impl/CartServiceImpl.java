package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Cart;
import com.casestudy.happy_paws.repository.ICartRepo;
import com.casestudy.happy_paws.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepo iCartRepo;
    @Override
    public Page<Cart> getAll(Pageable pageable) {
        return iCartRepo.findAll(pageable);
    }

    @Override
    public void save(Cart cart) {
        iCartRepo.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        iCartRepo.deleteById(id);
    }
}
