package com.yo.day1.dto.courseclass;

import com.yo.day1.domain.entity.ScheduleSlots;
import com.yo.day1.dto.course.CourseResponse;
import com.yo.day1.dto.room.RoomResponse;
import com.yo.day1.dto.teacher.TeacherResponse;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CourseClassResponse{
    private Long id;

    private String classCode;

    private String name;

    private CourseResponse courseResponse;

    private RoomResponse roomResponse;
    private ScheduleSlots scheduleSlots;
    private TeacherResponse mainTeacher;
    private TeacherResponse assistantTeacher;
    private String description;

    private double tuitionFee;

    private int totalSessions;

    private byte isActive;
}
