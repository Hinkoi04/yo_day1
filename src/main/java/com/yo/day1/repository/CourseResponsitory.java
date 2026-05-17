package com.yo.day1.repository;

import com.yo.day1.domain.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseResponsitory extends JpaRepository<Courses, Long> {
}
