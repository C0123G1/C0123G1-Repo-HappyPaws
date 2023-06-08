package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.repository.IEmployeeRepo;
import com.casestudy.happy_paws.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return iEmployeeRepo.findAll(pageable);
    }
}
