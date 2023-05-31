package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService ;

    @GetMapping("")
    public String index(@RequestParam("page") int page, Model model){
        Page<Account> accountList = accountService.getAllPage(page);
        model.addAttribute("accountList",accountList);
        return "/customers/account";
    }
    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("account" , new Account() );
        return "/customers/account-create";
    }
    @PostMapping("/save")
    public String save( @ModelAttribute("account") Account accountDTO , RedirectAttributes redirectAttributes){
       Account account = new Account();
        BeanUtils.copyProperties(accountDTO,account) ;
       accountService.save(account);
       redirectAttributes.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/account";
    }


}
