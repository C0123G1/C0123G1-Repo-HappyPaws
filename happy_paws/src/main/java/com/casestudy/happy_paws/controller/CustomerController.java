package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.AccountDTO;
import com.casestudy.happy_paws.dto.CustomerDTO;
import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.service.EmailService;
import com.casestudy.happy_paws.service.IAccountService;
import com.casestudy.happy_paws.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private EmailService emailService;

    @GetMapping("")
    public String index(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> customerList = customerService.getAllPage(page);
        model.addAttribute("customerList", customerList);


        return "customers/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customers/create";
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO ,BindingResult bindingResult,Model model ) {
//       new CustomerDTO().validate(customerDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "/customers/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        Account account = new Account(customerDTO.getAccountDTO().getUsername(),customerDTO.getAccountDTO().getPassword(),new Role(1,"CUSTOMER"));
        accountService.save(account);
        Account account1 = accountService.findAccount(account.getAccountId());
        int result = customerService.getRandom(10000,999999);
        emailService.sendEmail(customer.getEmail(),"Hello "+ customer.getName()  , "Bạn vui lòng nhập mã số xác nhận : " +result );
        account.setCode(result);
        customer.setAccount(account1);
        customerService.save(customer);
        model.addAttribute("mess", "Add New Successfully");
        model.addAttribute("account",account);

        return "/customers/pageCheck";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") Integer customerId,RedirectAttributes redirectAttributes){
          customerService.delete(customerId);
        redirectAttributes.addFlashAttribute("mess","Delete Successfully");
        return "redirect:/customer";
    }



    @GetMapping("/edit/{customerId}")
    public String edit(@PathVariable("customerId") Integer customerId ,  Model model) {
        Customer customer = customerService.findById(customerId);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer , customerDTO);
        Account account = customer.getAccount();
        customerDTO.setAccountDTO(new AccountDTO(account.getAccountId(), account.getUsername(), account.getPassword(),account.getRole(),account.getCode(),account.isEnable()));
        model.addAttribute("customerDTO", customerDTO);
        return "/customers/edit";
    }

    @PostMapping("/update")
    private String update(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes) {

//        customerDTO.setAccount();
        new CustomerDTO().validate(customerDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "/customers/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
//        customer.setAccount(account);
        Account account = new Account(customerDTO.getAccountDTO().getAccountId(),customerDTO.getAccountDTO().getUsername(),customerDTO.getAccountDTO().getPassword(),customerDTO.getAccountDTO().getCode(),customerDTO.getAccountDTO().isEnable(),customerDTO.getAccountDTO().getRole());
        customer.setAccount(account);
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Update Successfully");
        return "redirect:/customer";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "page ",defaultValue = "0") int page ,@RequestParam("name") String name
            , @RequestParam("phone") String phone ,@RequestParam("username") String username ,Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<Customer> customerList=customerService.findByCustomer( '%'+ name + '%' , '%'+ phone + '%', '%'+username + '%',pageable);
        model.addAttribute("customerList",customerList);
        return "customers/index";
    }
    @PostMapping("/check")
    public String check(@RequestParam("accountId") Integer id ,@RequestParam("code") int code, Model model ){
        Account account = accountService.findById(id);
        Customer customer = new Customer();
        if( code == account.getCode()){
            account.setEnable(true);
            accountService.save(account);
            return "redirect:/customer";

        }
        int result = customerService.getRandom(10000,999999);
        emailService.sendEmail(customer.getEmail(),"Hello "+ customer.getName()  , "Bạn vui lòng nhập mã số xác nhận : " +result );
        account.setCode(result);
        accountService.save(account);
        model.addAttribute("account",account);
        model.addAttribute("mess","Create Successfully");
        return "/customers/pageCheck";

    }
    @GetMapping("/{customerId}/view")
    public String view (@PathVariable("customerId") Integer customerId  ,Model model){
        model.addAttribute("customer",customerService.findById(customerId));
        return "/customers/view";
    }


}
