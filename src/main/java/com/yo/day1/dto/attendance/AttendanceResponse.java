package com.yo.day1.dto.attendance;

import com.yo.day1.domain.entity.CourseClass;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.domain.entity.User;
import com.yo.day1.domain.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AttendanceResponse {
    Long id;
    Long courseClassId;
    String className;
    Long studentId;
    String studentName;
    LocalDate attendanceDate;
    String status;
    String note;
    Long recordedByUserId;
    String recordedByUsername;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
