package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
}
