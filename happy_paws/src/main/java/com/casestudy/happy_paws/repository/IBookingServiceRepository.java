package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.dto.BookingServiceDTO;
import com.casestudy.happy_paws.model.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IBookingServiceRepository extends JpaRepository<BookingService, Long> {

    @Query(value = "select bs from  BookingService  bs inner  join BookingServiceDetail bsd on bs.bookingServiceId = bsd.bookingService.bookingServiceId where bs.isDelete = false group by bs.bookingServiceId")
    Page<BookingService> findAllWithTotal(Pageable pageable);


    @Query(value = "select bs from  BookingService  bs inner  join BookingServiceDetail bsd on bs.bookingServiceId = bsd.bookingService.bookingServiceId where bs.isDelete = false and bs.bookingDate = :searchDate group by bs.bookingServiceId ")
    Page<BookingService> searchByDate(Pageable pageable,@Param("searchDate") LocalDate searchDate);


//    @Query(value = "select sum ")

}
