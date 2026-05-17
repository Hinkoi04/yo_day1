package com.yo.day1.dto.room;

import java.time.LocalDateTime;

public record RoomResponse(
        Long id,
        String roomCode,
        String name,
        Integer capacity,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
