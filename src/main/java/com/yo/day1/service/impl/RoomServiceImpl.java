package com.yo.day1.service.impl;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Room;
import com.yo.day1.dto.room.RoomResponse;
import com.yo.day1.dto.room.RoomUpsertRequest;
import com.yo.day1.repository.RoomRepository;
import com.yo.day1.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public Page<RoomResponse> findAll(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            return roomRepository.findByNameContainingIgnoreCaseOrRoomCodeContainingIgnoreCase(search, search, pageable)
                    .map(this::toResponse);
        }
        return roomRepository.findAll(pageable).map(this::toResponse);
    }

    @Transactional
    public RoomResponse create(RoomUpsertRequest request) {
        Room room = new Room();
        apply(room, request);
        return toResponse(roomRepository.save(room));
    }

    @Transactional
    public RoomResponse update(Long id, RoomUpsertRequest request) {
        Room room = getRoom(id);
        apply(room, request);
        return toResponse(roomRepository.save(room));
    }

    @Transactional(readOnly = true)
    public RoomResponse findById(Long id) {
        return toResponse(getRoom(id));
    }

    @Transactional(readOnly = true)
    public Room getRoom(Long id) throws NotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Room not found: " + id));
    }

    @Transactional
    public void delete(Long id) {
        Room room = getRoom(id);
        roomRepository.delete(room);
    }

    private void apply(Room room, RoomUpsertRequest request) {
        room.setRoomCode(request.roomCode());
        room.setName(request.name());
        room.setCapacity(request.capacity());
        room.setDescription(request.description());
    }

    private RoomResponse toResponse(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getRoomCode(),
                room.getName(),
                room.getCapacity(),
                room.getDescription(),
                room.getCreatedAt(),
                room.getUpdatedAt()
        );
    }
}
