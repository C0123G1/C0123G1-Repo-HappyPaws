package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.BookingService;
import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.service.IBookingServiceService;
import com.casestudy.happy_paws.service.IBookingServiceServiceDetail;
import com.casestudy.happy_paws.service.IPetServiceService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/admin/booking-service")
public class BookingServiceController {
    @Autowired
    private IBookingServiceService iBookingServiceService;

    @Autowired
    private IPetServiceService iPetServiceService;

    @Autowired private IBookingServiceServiceDetail iBookingServiceServiceDetail;

//    @Autowired private

    @GetMapping("/list")
    public String showPage(Model model, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.asc("bookingDate")));
        Page<BookingService> bookingServicePage = iBookingServiceService.findPage(pageable);
        model.addAttribute("bookingServicePage", bookingServicePage);
        return "pet-service/booking/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        iBookingServiceService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/api/admin/booking-service/list";
    }

    @GetMapping("/create")
    public String createView(Model model, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<Customer> customerPage = iBookingServiceService.findPageCustomer(pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("bookingService", new BookingService());

        return "pet-service/booking/select-customer-list";

    }


    @GetMapping("/chooseService")
    public String createBooking(@RequestParam("customerId") Integer customerId, @RequestParam("bookingDate") String bookingDate, @RequestParam("bookingTime") String time, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model) {
        Customer customer = iBookingServiceService.findCustomerById(customerId);
        LocalDate date = LocalDate.parse(bookingDate);

        BookingService bookingService = new BookingService();
        bookingService = new BookingService(customer, date, time);
        iBookingServiceService.save(bookingService);
        model.addAttribute("bookingServiceDetail", new BookingServiceDetail());
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
        model.addAttribute("petServicePage", petServicePage);
        model.addAttribute("bookingService", bookingService);
        Boolean checked = true;
        model.addAttribute("checked", checked);

        return "pet-service/booking/select-service";
    }

    //    @GetMapping("/selectService/{customerId}")
//    public String selectService(@PathVariable("customerId")Integer customerId, Model model){
//        Customer customer = iBookingServiceService.findCustomerById(customerId);
//        BookingService bookingService = new BookingService();
//        bookingService.setCustomer(customer);
//        iBookingServiceService.save(bookingService);
//        model.addAttribute("bookingService",bookingService);
//        return "pet-service/booking/select-time";
//    }
    @PostMapping("/bookingServiceDetail/{bookingServiceId}")
    public String detail(@PathVariable("bookingServiceId") Long bookingServiceId, @RequestParam("petServiceId") Long petServiceId , RedirectAttributes redirectAttributes, Model model) {


        BookingService bookingService = iBookingServiceService.findBookingServiceById(bookingServiceId);

        PetService petService = iPetServiceService.findById(petServiceId);

        Double price = petService.getPrice();

        BookingServiceDetail bookingServiceDetail = new BookingServiceDetail(price,petService,bookingService);

        iBookingServiceServiceDetail.save(bookingServiceDetail);

//        redirectAttributes.addFlashAttribute("customerId",bookingService.getCustomer().getCustomerId());

//        model.addAttribute("petServicePage", petServicePage);
//        redirectAttributes.addFlashAttribute("bookingService", bookingService);

        return "redirect:/api/admin/booking-service/list";
    }
//    @GetMapping("/addMore")
//    public String addMore(@RequestParam("bookingService") BookingService bookingService, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model){
//        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
//        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
//        model.addAttribute("petServicePage", petServicePage);
//        model.addAttribute("bookingService", bookingService);
//        Boolean checked = true;
//        model.addAttribute("checked", checked);
//
//        return "pet-service/booking/select-service";
//    }
}























