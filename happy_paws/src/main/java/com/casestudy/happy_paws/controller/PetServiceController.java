package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.PetServiceDTO;
import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.model.Supplies;
import com.casestudy.happy_paws.service.IPetServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RequestMapping("/service")

@Controller
public class PetServiceController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/resources/static/service-img";
    @Autowired
    private IPetServiceService iPetServiceService;
    @Value("${upload.path}")
    private String fileUpload;



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
    @Autowired private ServletContext context;
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("service") PetServiceDTO petServiceDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes,
                         @RequestParam("image") MultipartFile file) throws IOException {
        new PetServiceDTO().validate(petServiceDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "service/service-create";
        }

//        if (multipartFile!=null){
//            String imagePath = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//            petServiceDTO.setImage(imagePath);
//            String uploadDir = "service-photos/" + petServiceDTO.getId();
//            FileUploadUtil.saveFile(uploadDir, imagePath, multipartFile);
//        }
//        PetService petService = new PetService.PetServiceBuilder(petServiceDTO.getName()).description(petServiceDTO.getDescription()).build();
//        MultipartFile multipartFile = petServiceDTO.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(petServiceDTO.getImage().getBytes(), new File(this.fileUpload+fileName));
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }




//
//        BeanUtils.copyProperties(petServiceDTO,petService);
//        petService.setImage(fileName);
//
//
//
//        iPetServiceService.save(petService);
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        return "redirect:/service";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable("id") Integer id, Model model){
        PetService petService = new PetService();
        petService = iPetServiceService.findById(id);
        model.addAttribute("petService",petService);
        return "service/service-edit";
    }
}
