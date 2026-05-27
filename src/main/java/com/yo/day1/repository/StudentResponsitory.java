package com.yo.day1.repository;

import com.yo.day1.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface StudentResponsitory extends JpaRepository<Student,Long> {
    List<Student> findByFullNameContainingIgnoreCase(String name);
    List<Student> findByLatestScoreBetween(BigDecimal minScore, BigDecimal maxScore);
}