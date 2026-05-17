package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "schedule_slots")
public class ScheduleSlots extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String slotCode;
    private byte weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    @Column(columnDefinition = "text")
    private String note;
}
