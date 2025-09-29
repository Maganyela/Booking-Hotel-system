package com.hotelbooking.Hotel.Booking.service.interfaces;

import com.hotelbooking.Hotel.Booking.dto.LoginRequest;
import com.hotelbooking.Hotel.Booking.dto.Response;
import com.hotelbooking.Hotel.Booking.entity.User;

public interface IUserService {

    Response register(User user);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response getUserBookingHistory(String userId);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyInfo(String email);

}
