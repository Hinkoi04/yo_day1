package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Course;
import com.yo.day1.repository.CourseResponsitory;
import com.yo.day1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseResponsitory courseResponsitory;

    public List<Course> findAll(){
        return courseResponsitory.findAll();
    }
    public List<Course> findByCourseActive(){
        return courseResponsitory.findByCourseActive();
    }

    public Optional<Course> findById(Long id){
        return courseResponsitory.findById(id);
    }

    public Course save(Course course){
        return courseResponsitory.save(course);
    }

    public Course update(Long id, Course course) {
        return courseResponsitory.findById(id).map(existingCourse -> {
            existingCourse.setCourseCode(course.getCourseCode());
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setTuitionFee(course.getTuitionFee());
            existingCourse.setTotalSessions(course.getTotalSessions());
            existingCourse.setIsActive(course.getIsActive());
            return courseResponsitory.save(existingCourse);
        }).orElseThrow(() -> new RuntimeException("Khong tim thay: " + id));
    }
    public void delete(Long id){
        courseResponsitory.deleteById(id);
    }
}
