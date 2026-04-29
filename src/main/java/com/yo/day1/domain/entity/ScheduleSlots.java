package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class ScheduleSlots extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String slotCode;
    private Integer weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    @Column(columnDefinition = "text")
    private String note;
}
