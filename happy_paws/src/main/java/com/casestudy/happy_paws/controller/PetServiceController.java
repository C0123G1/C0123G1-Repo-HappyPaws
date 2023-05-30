package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.PetServiceDTO;
import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.service.IPetServiceService;
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

import java.util.Optional;

@RequestMapping("/service")

@Controller
public class PetServiceController {
    @Autowired
    private IPetServiceService iPetServiceService;
    @GetMapping("")
    public String GetList(Model model, @RequestParam(value = "page", defaultValue = "0")Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0),10);
        Page<PetService> page = iPetServiceService.findPage(pageable);
        model.addAttribute("serviceList", page);
        return "service/service-list";
    }
    @GetMapping("/create")
    public String createView(@ModelAttribute("service")PetServiceDTO petServiceDTO){
        return "service/service-create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("service") PetServiceDTO petServiceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new PetServiceDTO().validate(petServiceDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "service/service-create";
        }
        PetService petService = new PetService();
        BeanUtils.copyProperties(petServiceDTO,petService);
        iPetServiceService.save(petService);
        return "redirect:/service";

    }
}
