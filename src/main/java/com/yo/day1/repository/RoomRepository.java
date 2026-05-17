package com.yo.day1.repository;

import com.yo.day1.domain.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Page<Room> findByNameContainingIgnoreCaseOrRoomCodeContainingIgnoreCase(String name, String roomCode, Pageable pageable);
}
