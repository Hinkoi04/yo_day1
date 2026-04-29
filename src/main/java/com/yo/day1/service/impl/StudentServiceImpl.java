package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Student;
import com.yo.day1.responsitory.StudentResponsitory;
import com.yo.day1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentResponsitory studentResponsitory;
    public StudentServiceImpl(StudentResponsitory studentResponsitory) {
        this.studentResponsitory = studentResponsitory;
    }

    public List<Student> findByAll(){
        return studentResponsitory.findAll();
    }
}
