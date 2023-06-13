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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IProductService iProductService;

    @GetMapping("/cart")
    public String displayCart(Model model) {
        List<Cart> list = iCartService.getAll();
        model.addAttribute("cartList", list);
        model.addAttribute("totalItem", iCartService.countItemQuantity());
        model.addAttribute("totalBill",iCartService.countTotalPayment());
        return "cart_view/cart";
    }

    @GetMapping("/delete-product")
    public String deleteProductInCart(@RequestParam("id") Long id) {
        iCartService.deleteCart(id);
        return "redirect:/cart";
    }
    @GetMapping("/add/{id}")
    public String addQuantityToCart(@PathVariable("id")Long cartId) {
        Cart cart1 = iCartService.findById(cartId);
        cart1.setQuantity(cart1.getQuantity()+1);
        iCartService.save(cart1);
        return "redirect:/cart";
    }
    @GetMapping("/reduce/{id}")
    public String reduceProductInCart(@PathVariable("id") Long cartID){
        Cart cart = iCartService.findById(cartID);
        cart.setQuantity(cart.getQuantity()-1);
        int newQuantity = cart.getQuantity();
        iCartService.save(cart);
        if(newQuantity ==0){
            iCartService.deleteCart(cartID);
        }
        return "redirect:/cart";
    }
}

