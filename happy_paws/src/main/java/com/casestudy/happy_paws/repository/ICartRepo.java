package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepo extends JpaRepository<Cart,Long> {
}
