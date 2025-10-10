package com.hotelbooking.Hotel.Booking.service.interfaces;

import com.hotelbooking.Hotel.Booking.dto.Response;
import com.hotelbooking.Hotel.Booking.entity.Booking;

public interface IBookingService {

    Response savedBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
