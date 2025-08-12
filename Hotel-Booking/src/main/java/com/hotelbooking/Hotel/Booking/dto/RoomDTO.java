package com.hotelbooking.Hotel.Booking.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hotelbooking.Hotel.Booking.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private String id;

    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<BookingDTO> bookings = new ArrayList<>();
}
