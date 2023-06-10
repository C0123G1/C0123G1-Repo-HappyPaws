package com.casestudy.happy_paws.service;


import com.casestudy.happy_paws.model.BookingService;
import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookingServiceService {

    Page<BookingService> findPage(Pageable pageable);

    void deleteById(Long id);

    Page<Customer> findPageCustomer(Pageable pageable);

    Customer findCustomerById(Integer customerId);

    void save(BookingService bookingService);

    BookingService findBookingServiceById(Long bookingServiceId);
}
