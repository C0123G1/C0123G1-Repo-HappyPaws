package com.casestudy.happy_paws.restful;

import com.casestudy.happy_paws.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/order-detail-rest")
public class OrderDetailRestController {
    @DeleteMapping("")
    public Boolean deleteProduct(@RequestParam("index") Integer index,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        return true;
    }
}
