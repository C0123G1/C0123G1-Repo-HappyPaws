package com.casestudy.happy_paws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/happy-paws-home")
public class HappyPawsController {
    @GetMapping("")
    public String showHome(){
        return "/happy_paws/index";
    }
}
