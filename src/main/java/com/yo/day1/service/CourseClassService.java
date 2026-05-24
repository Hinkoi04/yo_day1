package com.yo.day1.service;

import com.yo.day1.domain.entity.CourseClass;
import com.yo.day1.dto.courseclass.CourseClassResponse;
import com.yo.day1.dto.courseclass.CourseClassUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseClassService {
    CourseClass getCourseClass(Long id);
    CourseClassResponse update(Long id, CourseClassUpsertRequest req);
    CourseClassResponse create(CourseClassUpsertRequest req);
    Optional<CourseClassResponse> findById(Long id);
    List<CourseClassResponse> findAll();
}
