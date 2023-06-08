package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.OrderDetail;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.service.IOrderDetailService;
import com.casestudy.happy_paws.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("")
    public String showOrderDetail(@RequestParam("orderId") Long orderId, @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<OrderDetail> orderDetailPage = iOrderDetailService.findAllOrderDetailByOrderId(pageable, orderId);
        model.addAttribute("orderDetailPage", orderDetailPage);
        model.addAttribute("orderId", orderId);
        model.addAttribute("pageList", true);
        return "orders/order_detail";
    }

    @GetMapping("/create")
    public String create(@RequestParam("customerId") Long customerId, @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        model.addAttribute("customerId", customerId);
        model.addAttribute("productPage", iOrderDetailService.findAllProduct(pageable));
        return "orders/product_list";
    }

    @PostMapping("/add-product")
    public String save(@RequestParam("productId") Long productId, @RequestParam("customerId") Integer customerId, @RequestParam(value = "orderId", defaultValue = "0") Long orderId, @RequestParam("quantity") Integer quantity, Model model) {
        Customer customer = iOrderDetailService.findCustomerById(customerId);
        Orders orders;
        if (orderId == 0) {
            orders = new Orders(customer);
        } else {
            orders = new Orders(orderId, customer);
        }
        boolean statusSave = iOrderService.saveOrder(orders);
        Product product = iOrderDetailService.findProductById(productId);
        OrderDetail orderDetail = new OrderDetail(product, orders, quantity, product.getPrice());
        boolean statusSaveOrderDetail = iOrderDetailService.saveOrderDetail(orderDetail);
        Pageable pageable = PageRequest.of(0, 8);
        model.addAttribute("customerId", customerId);
        model.addAttribute("orders", orders);
        model.addAttribute("productPage", iOrderDetailService.findAllProduct(pageable));
        return "orders/product_list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("orderId") Long orderId,@RequestParam("name") String name,@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page,8);
        model.addAttribute("productPage",iOrderDetailService.searchProductOrderDetail(name,orderId,pageable));
        model.addAttribute("name",name);
        model.addAttribute("orderId",orderId);
        model.addAttribute("pageSearch", true);
        return "orders/order_detail";
        // can fix lai
    }

}
