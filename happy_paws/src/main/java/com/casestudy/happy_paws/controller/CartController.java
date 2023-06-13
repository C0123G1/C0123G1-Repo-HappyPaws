package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.*;
import com.casestudy.happy_paws.service.ICartService;
import com.casestudy.happy_paws.service.ICustomerService;
import com.casestudy.happy_paws.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IProductService iProductService;

    @GetMapping("/cart")
    public String display(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("dateCreate").descending());
        Page<Cart> list = iCartService.getAll(pageable);
        model.addAttribute("cartList", list);
        return "cart_view/cart";
    }

    @GetMapping("/delete-product")
    public String deleteProductInCart(@RequestParam("id") Long id) {
        iCartService.deleteCart(id);
        return "redirect:/cart";
    }


    }

