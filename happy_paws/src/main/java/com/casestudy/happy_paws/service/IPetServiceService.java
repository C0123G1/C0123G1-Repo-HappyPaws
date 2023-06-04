package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPetServiceService {
    Page<PetService> findPage(Pageable pageable);

    void save(PetService petService);

    PetService findById(Integer id);
}
