package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;
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
        Pageable pageable = PageRequest.of(page,8);
        Page<Orders> ordersPage = iOrderService.findAll(pageable);
        model.addAttribute("ordersPage",ordersPage);
        model.addAttribute("pageList",true);
        return "orders/orders_list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam("phone") String phone,@RequestParam(value = "page",defaultValue = "0") Integer page, Model model){
        Pageable pageable = PageRequest.of(page,8);
        Page<Orders> ordersPage = iOrderService.searchByNameAndPhone(name, phone,pageable);
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("ordersPage",ordersPage);
        model.addAttribute("pageSearch",true);
        return "orders/orders_list";
    }
    @GetMapping("/create")
    private String create(@RequestParam(value = "page",defaultValue = "0") Integer page,Model model){
        Pageable pageable = PageRequest.of(page,8);
        model.addAttribute("customerPage",iOrderService.findAllCustomer(pageable));
        model.addAttribute("customer",new Customer());
        model.addAttribute("pageList",true);
        return "orders/customer_list";
    }
    @GetMapping("/search-customer")
    public String searchCustomer(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                 @RequestParam(value = "page",defaultValue = "0") Integer page, Model model){
        Pageable pageable = PageRequest.of(page,8);
        model.addAttribute("customerPage",iOrderService.searchCustomerByNameAndPhone(name,phone,pageable));
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("pageSearch",true);
        return "orders/customer_list";
    }
    @GetMapping("/search-product")
    public String searchProduct(@RequestParam("chosePrice") Integer chosePrice,@RequestParam("name") String name,@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page,8);
        Page<Product> productPage = iOrderService.searchProductByNameAndPrice(name,chosePrice,pageable);
        model.addAttribute("productPage",productPage);
        model.addAttribute("name",name);
        model.addAttribute("chosePrice",chosePrice);
        model.addAttribute("pageSearch", true);
        return "orders/product_list";
    }
}
