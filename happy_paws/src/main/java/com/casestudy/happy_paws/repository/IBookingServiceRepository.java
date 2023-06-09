package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingServiceRepository extends JpaRepository<BookingService,Long> {
}
