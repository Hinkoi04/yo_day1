package com.yo.day1.service;

import com.yo.day1.domain.entity.Courses;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Courses> findAll();
    Optional<Courses> findById(Long id);
    Courses save(Courses course);
    Courses update(Long id, Courses course);
    void delete(Long id);
}
