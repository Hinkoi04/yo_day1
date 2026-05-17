package com.yo.day1.service;

import com.yo.day1.domain.entity.ScheduleSlots;

import java.util.List;
import java.util.Optional;

public interface ScheduleSlotService {
    List<ScheduleSlots> findAll();
    Optional<ScheduleSlots> findById(Long id);
    ScheduleSlots save(ScheduleSlots scheduleSlots);
    void deleteById(Long id);
}
