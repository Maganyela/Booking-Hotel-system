package com.hotelbooking.Hotel.Booking.repo;

import com.hotelbooking.Hotel.Booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("")
    List<String> findDistinctRoomTypes();
}
