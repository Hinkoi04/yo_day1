package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import com.yo.day1.domain.enums.CoursesClassStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class CourseClass extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String classCore;

    private String name;

    @ManyToOne
    @JoinColumn(name = "courses_id", nullable = false)
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "schedule_slot_id", nullable = false)
    private ScheduleSlots scheduleSlots;

    @ManyToOne
    @JoinColumn(name = "main_teacher_id", nullable = false)
    private Teachers mainTeacher;

    @ManyToOne
    @JoinColumn(name = "assistent_teacher_id")
    private Teachers assistantTeacher;

    private LocalTime startDate;
    private LocalTime endDate;

    private int maxStudents;

    @Column(columnDefinition = "decimal",precision = 12,scale = 2)
    private double tuitionFee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private CoursesClassStatus status=CoursesClassStatus.OPEN;
}
