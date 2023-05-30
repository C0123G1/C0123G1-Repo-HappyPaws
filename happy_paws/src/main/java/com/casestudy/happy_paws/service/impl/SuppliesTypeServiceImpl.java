package com.casestudy.happy_paws.service.impl;


import com.casestudy.happy_paws.model.SuppliesType;
import com.casestudy.happy_paws.repository.ISuppliesTypeRepository;
import com.casestudy.happy_paws.service.ISuppliesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesTypeServiceImpl implements ISuppliesTypeService {
    @Autowired
    private ISuppliesTypeRepository iSuppliesTypeRepository;

    @Override
    public List<SuppliesType> findAll() {
        return iSuppliesTypeRepository.findAll();
    }
}
