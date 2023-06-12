package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.BookingServiceDetail;

public interface IBookingServiceServiceDetail {
    void save(BookingServiceDetail bookingServiceDetail);

    Double getTotalByIdBooking(Long bookingServiceId);
}
