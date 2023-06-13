package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.service.IProductService;
import com.casestudy.happy_paws.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class HappyPawsController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;
    @GetMapping("")
    public String showHome(@RequestParam(value = "page",defaultValue = "0")Integer page, Model model){
        Pageable pageable = PageRequest.of(page,6);
        model.addAttribute("productPage",iProductService.findAll(pageable));
        model.addAttribute("productTypeList",iProductTypeService.findAll());
        return "/happy_paws/index";
    }
}
