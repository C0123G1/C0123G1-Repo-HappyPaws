package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("/")
    public String display(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,3, Sort.by("dateCreate").descending());
        Page<Employee> list = iEmployeeService.getAll(pageable);
        model.addAttribute("employeeList",list);
        return "employee_view/employee_list";
    }
}
