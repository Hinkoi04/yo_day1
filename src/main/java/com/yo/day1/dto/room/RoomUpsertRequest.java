package com.yo.day1.dto.room;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RoomUpsertRequest(
        @NotBlank @Size(max = 20) String roomCode,
        @NotBlank @Size(max = 100) String name,
        @NotNull @Min(1) Integer capacity,
        @Size(max = 255) String description
) {
}
