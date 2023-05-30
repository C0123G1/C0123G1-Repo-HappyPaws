package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.repository.IPetServiceRepository;
import com.casestudy.happy_paws.service.IPetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetServiceServiceImpl implements IPetServiceService {
    @Autowired
     private IPetServiceRepository iPetServiceRepository;

    @Override
    public Page<PetService> findPage(Pageable pageable) {
        return iPetServiceRepository.findAll(pageable);
    }

    @Override
    public void save(PetService petService) {
        iPetServiceRepository.save(petService);
    }
}
