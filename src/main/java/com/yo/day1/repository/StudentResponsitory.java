package com.yo.day1.repository;

import com.yo.day1.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentResponsitory extends JpaRepository<Student,Long> {

}
