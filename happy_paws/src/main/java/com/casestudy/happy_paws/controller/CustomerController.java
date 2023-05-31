package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.AccountDTO;
import com.casestudy.happy_paws.dto.CustomerDTO;
import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.service.IAccountService;
import com.casestudy.happy_paws.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public String index(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> customerList = customerService.getAllPage(page);
        model.addAttribute("customerList", customerList);
        return "/customers/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO()); // khong trả về DTO nè
        return "/customers/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") CustomerDTO customerDTO, @ModelAttribute("account") AccountDTO accountDTO , RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        Account account = new Account(customer.getAccount().getUsername(),customer.getAccount().getPassword(),new Role(1,"Customer"));
        accountService.save(account); // khóa chish nên ko cho trùng role
      // acccount cái roleId khong lien quan khoa chinh
        Account account1 = accountService.findAccount();
        customer.setAccount(account1);
        customerService.save(customer);// chỗ ni phải lưu account trước thấy id role null
        redirectAttributes.addFlashAttribute("mess", "Add New Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customers/edit";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute("customer") CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Update Successfully");
        return "redirect:/customer";
    }

}
