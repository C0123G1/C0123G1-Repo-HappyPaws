package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.PetServiceDTO;
import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.service.IPetServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/pet-service")
public class PetServiceController {
    @Autowired
    private IPetServiceService iPetServiceService;

    @GetMapping("/list")
    public String ShowPage(Model model, @RequestParam(value = "page", defaultValue = "0")Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(0),5, Sort.by(Sort.Order.desc("updateTime")));
        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
        model.addAttribute("petServicePage",petServicePage);
        return "pet-service/list";
    }

    @GetMapping("/create")
    public String createView(@ModelAttribute("petServiceDTO")PetServiceDTO petServiceDTO){
        return "pet-service/create";
    }

    @PostMapping("/create")
    public String saveService(@Validated @ModelAttribute("petServiceDTO")PetServiceDTO petServiceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "pet-service/create";
        }

        PetService petService = new PetService();
        BeanUtils.copyProperties(petServiceDTO,petService);
        iPetServiceService.save(petService);
        redirectAttributes.addFlashAttribute("message", "Added Successfully");
        return "redirect:/pet-service/list";
    }

    @GetMapping("/edit/{id}")
    public String editView( @PathVariable("id") Long id,Model model){
        PetService petService = iPetServiceService.findById(id);
        PetServiceDTO petServiceDTO = new PetServiceDTO();
        BeanUtils.copyProperties(petService,petServiceDTO);
        model.addAttribute("petServiceDTO",petServiceDTO);
        return "pet-service/update";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("petServiceDTO") PetServiceDTO petServiceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            return "pet-service/update";
        }
        PetService petService = new PetService();
        BeanUtils.copyProperties(petServiceDTO,petService);
        iPetServiceService.save(petService);
        redirectAttributes.addFlashAttribute("message","Updated Successfully");
        return "redirect:/pet-service/list";

    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        iPetServiceService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/pet-service/list";

    }


}
