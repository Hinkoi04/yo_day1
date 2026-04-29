package com.yo.day1.responsitory;

import com.yo.day1.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentResponsitory extends JpaRepository<Student,Long> {

}
