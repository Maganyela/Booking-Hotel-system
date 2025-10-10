package com.hotelbooking.Hotel.Booking.utils;

import com.hotelbooking.Hotel.Booking.dto.BookingDTO;
import com.hotelbooking.Hotel.Booking.dto.RoomDTO;
import com.hotelbooking.Hotel.Booking.dto.UserDTO;
import com.hotelbooking.Hotel.Booking.entity.Booking;
import com.hotelbooking.Hotel.Booking.entity.Room;
import com.hotelbooking.Hotel.Booking.entity.User;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static final String ALPHANUMERICAL_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        private static final SecureRandom secureRandom = new SecureRandom();

        public static String generateRandomConfirmationCode(int length) {

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i< length; i++) {
                int randomIndex = secureRandom.nextInt(ALPHANUMERICAL_STRING.length());
                char randomChar = ALPHANUMERICAL_STRING.charAt(randomIndex);
                stringBuilder.append(randomChar);
            }
            return stringBuilder.toString();
        }

        public static UserDTO mapUserEntityToUserDTO(User user) {
            UserDTO userDTO = new UserDTO();

           userDTO.setId(String.valueOf(user.getId()));
           userDTO.setName(user.getName());
           userDTO.setEmail(user.getEmail());
           userDTO.setPhoneNumber(user.getPhoneNumber());
           userDTO.setRole(user.getRole());

           return userDTO;
        }

    public static RoomDTO mapRoomEntityToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(String.valueOf(room.getId()));
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());


        return roomDTO;
    }

    public static RoomDTO mapRoomEntityToRoomDTOPlusBookings(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(String.valueOf(room.getId()));
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());

        if (room.getBookings() != null) {
            roomDTO.setBookings(room.getBookings().stream().map(Utils::mapBookingsEntityToBookigDTO).collect(Collectors.toList()));
        }
        return roomDTO;
    }
   public static BookingDTO mapBookingsEntityToBookigDTO(Booking booking) {

           BookingDTO bookingDTO = new BookingDTO();

           bookingDTO.setId(String.valueOf(booking.getId()));
           bookingDTO.setCheckInDate(booking.getCheckInDate());
           bookingDTO.setCheckOutDate(booking.getCheckOutDate());
           bookingDTO.setNumOfAdults(booking.getNumOfAdults());
           bookingDTO.setNumOfChildren(booking.getNumOfChildren());
           bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
           bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());

           return bookingDTO;
   }


    public static UserDTO mapUserEntityToUserDTOPlusUserBookingAndRoom(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(String.valueOf(user.getId()));
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());


        if (!user.getBookings().isEmpty()) {
            userDTO.setBookings(user.getBookings().stream().map(booking -> mapBookingEntityToBookingDTOPlusBookingRoom(booking,false)).collect(Collectors.toList()));
        }
        return userDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTOPlusBookingRoom(Booking  booking, boolean mapUser) {

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(String.valueOf(booking.getId()));
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildren(booking.getNumOfChildren());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());

           if (mapUser) {
               bookingDTO.setUser(Utils.mapUserEntityToUserDTO(booking.getUser()));
           }
           if (booking.getRoom() != null) {

               RoomDTO roomDTO = new RoomDTO();

               roomDTO.setId(String.valueOf(booking.getRoom().getId()));
               roomDTO.setRoomType(booking.getRoom().getRoomType());
               roomDTO.setRoomPrice(booking.getRoom().getRoomPrice());
               roomDTO.setRoomPhotoUrl(booking.getRoom().getRoomPhotoUrl());
               roomDTO.setRoomDescription(booking.getRoom().getRoomDescription());
           }
           return bookingDTO;
    }

    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
            return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
    }

    public static List<RoomDTO> mapRoomListEntityToRoomListDTO(List<Room> roomList) {
    return roomList.stream().map(Utils::mapRoomEntityToRoomDTO).collect(Collectors.toList());
   }

    public static List<BookingDTO> mapBookingListEntityToBookingListDTO(List<Booking> bookingList) {
        return bookingList.stream().map(Utils::mapBookingsEntityToBookigDTO).collect(Collectors.toList());
    }

}