package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.SuppliesDTO;
import com.casestudy.happy_paws.model.Supplies;
import com.casestudy.happy_paws.model.SuppliesType;
import com.casestudy.happy_paws.service.ISuppliesService;
import com.casestudy.happy_paws.service.ISuppliesTypeService;
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

import java.util.List;

@Controller
@RequestMapping("/supplies")
public class SuppliesController {
    @Autowired
    private ISuppliesService iSuppliesService;
    @Autowired
    private ISuppliesTypeService iSuppliesTypeService;

    @GetMapping("")
    public String displayHome(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Supplies> suppliesPage = iSuppliesService.findAll(pageable);
        List<SuppliesType> suppliesTypePage = iSuppliesTypeService.findAll();
        model.addAttribute("suppliesPage", suppliesPage);
        model.addAttribute("suppliesTypePage", suppliesTypePage);
        return "supplies/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("suppliesDTO", new SuppliesDTO());
        model.addAttribute("suppliesTypePage", iSuppliesTypeService.findAll());
        return "supplies/create_supplies";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("suppliesDTO") SuppliesDTO suppliesDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

        }
        Supplies supplies = new Supplies();
        BeanUtils.copyProperties(suppliesDTO, supplies);
        boolean statusSave = iSuppliesService.save(supplies);
        redirectAttributes.addFlashAttribute("statusSave", statusSave);
        return "redirect:/supplies";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        boolean statusDelete = iSuppliesService.deleteById(id);
        redirectAttributes.addFlashAttribute("statusDelete", statusDelete);
        return "redirect:/supplies";
    }

    @GetMapping("/update")
    public String updateInfo(@RequestParam("id") Long id, Model model) {
        Supplies supplies = iSuppliesService.findById(id);
        SuppliesDTO suppliesDTO = new SuppliesDTO();
        BeanUtils.copyProperties(supplies, suppliesDTO);
        model.addAttribute("suppliesDTO", suppliesDTO);
        model.addAttribute("suppliesTypePage", iSuppliesTypeService.findAll());
        return "/supplies/update_supplies";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("suppliesDTO") SuppliesDTO suppliesDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Supplies supplies = new Supplies();
        BeanUtils.copyProperties(suppliesDTO,supplies);
        boolean statusUpdate = iSuppliesService.save(supplies);
        redirectAttributes.addFlashAttribute("statusUpdate",statusUpdate);
        return "redirect:/supplies";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model){
        Supplies supplies = iSuppliesService.findById(id);
        model.addAttribute("supplies",supplies);
        return "/supplies/detail_supplies";
    }
}
