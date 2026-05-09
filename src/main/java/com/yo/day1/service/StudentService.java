package com.yo.day1.service;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.dto.student.StudentResponse;
import com.yo.day1.dto.student.StudentUpserRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentResponse> findByAll();
    Optional<StudentResponse> findById(Long id);
    StudentResponse create(StudentUpserRequest req);
    StudentResponse update(Long id, StudentUpserRequest req);
    void delete(Long id) throws NotFoundException;
}
