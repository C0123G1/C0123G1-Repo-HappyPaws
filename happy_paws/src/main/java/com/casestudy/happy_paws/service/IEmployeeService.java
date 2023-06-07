package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> getAll(Pageable pageable);
}
