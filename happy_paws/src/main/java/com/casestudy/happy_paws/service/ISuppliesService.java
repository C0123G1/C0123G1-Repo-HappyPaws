package com.casestudy.happy_paws.service;


import com.casestudy.happy_paws.model.Supplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISuppliesService {
    Page<Supplies> findAll(Pageable pageable);
    boolean save(Supplies supplies);
    boolean deleteById(Long id);
    Supplies findById(Long id);
}
