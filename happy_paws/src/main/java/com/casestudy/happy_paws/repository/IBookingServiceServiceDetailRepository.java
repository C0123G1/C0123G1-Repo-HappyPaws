package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.service.impl.BookingServiceServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingServiceServiceDetailRepository extends JpaRepository<BookingServiceDetail,Long> {


    @Query(value = "SELECT\n" +
            "       sum(bd.price) as total\n" +
            "FROM booking_service as bs\n" +
            "INNER JOIN booking_service_detail as bd on bs.booking_service_id = bd.booking_service_id\n" +
            "\n" +
            "WHERE (bs.is_delete = 0) and (bs.booking_service_id = ?1 )\n" +
            "GROUP BY bs.booking_service_id\n" +

            ";", nativeQuery = true)
    Double getTotal(Long bookingServiceId);
}
