package com.yo.day1.repository;

import com.yo.day1.domain.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherResponsitory extends JpaRepository<Teachers,Long> {
}
