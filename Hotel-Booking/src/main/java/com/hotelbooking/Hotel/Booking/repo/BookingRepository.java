package com.hotelbooking.Hotel.Booking.repo;

import com.hotelbooking.Hotel.Booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(Long roomId);

    List<Booking> findByBookingConfirmationCode(String confirmationCode);

    List<Booking> findByUserId(Long userId);
}
