package com.yo.day1.repository;

import com.yo.day1.domain.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseResponsitory extends JpaRepository<Courses, Long> {
    @Query("SELECT o FROM  Courses o WHERE o.isActive=1")
    List<Courses>findByCourseActive();

    Long id(Long id);
}
