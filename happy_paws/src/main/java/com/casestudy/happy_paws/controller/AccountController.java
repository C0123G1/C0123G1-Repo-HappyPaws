package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.service.IAccountService;
import com.casestudy.happy_paws.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService  roleService;

    @GetMapping("")
    public String index(@RequestParam(value = "page",defaultValue = "0") int page, Model model, HttpServletResponse response){
        Page<Account> accountList = accountService.getAllPage(page);
        model.addAttribute("accountList", accountList);

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private, o-age=0");

        return "/customers/account";
    }
//    @GetMapping("/create")
//    public  String create(Model model){
//        model.addAttribute("account" , new Account());
//        model.addAttribute("roleList" , roleService.findAll());
//        return "/customers/account-create";
//    }
//    @PostMapping("/save")
//    public String save(@ModelAttribute("account") Account account , RedirectAttributes redirectAttributes){
//        accountService.save(account);
//       redirectAttributes.addFlashAttribute("mess","Add New Successfully");
//        return "redirect:/account";
//    }
    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("account" , new Account());
        model.addAttribute("roleList" , roleService.findAll());
        return "/customers/account-create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("account") Account account , RedirectAttributes redirectAttributes){
        accountService.update(account);
        redirectAttributes.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/account";
    }




    @GetMapping("/login")
    public String login(Model model ){

        Account account = new Account();
        model.addAttribute("account", account);
        return "/customers/login";
    }
    @GetMapping( "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("message", "Logout");
        return "redirect:/customer";
    }

    @GetMapping("/{accountId}/edit")
    public String edit(@PathVariable("accountId")Integer accountId ,Model model){
        model.addAttribute("account",accountService.findById(accountId));
        model.addAttribute("roleList",roleService.findAll());
        return "/customers/account-edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("account") Account account , RedirectAttributes redirectAttributes){
        accountService.update(account);
        redirectAttributes.addFlashAttribute("mess","Update Successfully");
        return "redirect:/account";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("accountId")Integer accountId,RedirectAttributes redirectAttributes){
        accountService.delete(accountId);
        redirectAttributes.addFlashAttribute("mess","Delete Successfully");
        return "redirect:/account";
    }




}
