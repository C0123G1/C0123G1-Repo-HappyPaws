package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.service.impl.BookingServiceServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingServiceServiceDetailRepository extends JpaRepository<BookingServiceDetail,Long> {
}
