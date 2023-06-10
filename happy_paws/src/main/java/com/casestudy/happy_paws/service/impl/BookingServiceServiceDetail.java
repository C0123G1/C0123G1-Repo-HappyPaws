package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.repository.IBookingServiceServiceDetailRepository;
import com.casestudy.happy_paws.service.IBookingServiceServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceServiceDetail implements IBookingServiceServiceDetail {
    @Autowired private IBookingServiceServiceDetailRepository iBookingServiceServiceDetailRepository;
    @Override
    public void save(BookingServiceDetail bookingServiceDetail) {
        iBookingServiceServiceDetailRepository.save(bookingServiceDetail);
    }
}
