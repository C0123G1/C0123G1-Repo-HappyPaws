package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("accountController")
public class AccountController {

    @Autowired
    private IAccountService accountService;



    @GetMapping("")
    public String index( Model model){
        List<Account> accountList = accountService.findAll();
        model.addAttribute("accountList", accountList);
        return "/customers/user";
    }
//    @GetMapping("/create")
//    public  String create(Model model){
//        model.addAttribute("user" , new AccountDTO() );
//        return "/customers/account-create";
//    }
//    @PostMapping("/save")
//    public String save(@ModelAttribute("user") AccountDTO userDTO , RedirectAttributes redirectAttributes){
//       Account user = new Account();
//        BeanUtils.copyProperties(userDTO,user) ;
//        Role role =  new Role(user.getRole().getRoleId(),user.getRole().getNameRole());
//        userService.save(role);
//        Role role1 = uss
//       userService.save(user);
//       redirectAttributes.addFlashAttribute("mess","Add New Successfully");
//        return "redirect:/user";
//    }
//


//
    @GetMapping("/login")
    public String login(Model model ){

        Account account = new Account();
        model.addAttribute("account", account);
        return "/customers/login";
    }
    @GetMapping( "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "redirect:/customer";
    }


//
//    @GetMapping("/")
//    public String sessions(HttpServletRequest httpServletRequest){
//
//        Cookie[] cookies = httpServletRequest.getCookies();
//        if (cookies!=null){
//            for ( Cookie cookie: cookies) {
//                if(cookie.getName().equals("cookieUser")){
//                    httpServletRequest.setAttribute("name",cookie.getValue());
//                }
//                if(cookie.getName().equals("cookiePass")){
//                    httpServletRequest.setAttribute("pass",cookie.getValue());
//                }
//            }
//
//        }
//        return "redirect:/";
//
//    }


//    @PostMapping("/userLogin")
//    public String LoginUser( HttpServletRequest httpServletRequest, @ModelAttribute("user") Account user, Model model ) {
//        String username = user.getUsername();
//        Account user1 = userService.findUser(username);
//        if (user.getPassword().equals(user1.getPassword())) {
//            HttpSession session = httpServletRequest.getSession();
//            session.setAttribute("user", user);
//            model.addAttribute("mess"," Login Successfully");
//            return "redirect:/customer";
//        } else {
//            model.addAttribute("mess","Login fail");
//
//            return "/customers/error" ;
//        }
//    }



}
