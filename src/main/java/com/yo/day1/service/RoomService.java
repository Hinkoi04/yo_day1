package com.yo.day1.service;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Room;
import com.yo.day1.dto.room.RoomResponse;
import com.yo.day1.dto.room.RoomUpsertRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {
    Page<RoomResponse> findAll(String search, Pageable pageable);
    RoomResponse create(RoomUpsertRequest request);
    RoomResponse update(Long id, RoomUpsertRequest request);
    RoomResponse findById(Long id);
    Room getRoom(Long id) throws NotFoundException;
    void delete(Long id);

}
