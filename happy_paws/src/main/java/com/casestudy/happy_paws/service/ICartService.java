package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Cart;
import com.casestudy.happy_paws.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICartService {
    Page<Cart> getAll(Pageable pageable);
    void save(Cart cart);
void deleteCart(Long id);


}
