package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @GetMapping("")
    public String showList(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model){
        Pageable pageable = PageRequest.of(page,10);
        Page<Orders> ordersPage = iOrderService.findAll(pageable);
        model.addAttribute("ordersPage",ordersPage);
        return "orders/orders_list";
    }
}
