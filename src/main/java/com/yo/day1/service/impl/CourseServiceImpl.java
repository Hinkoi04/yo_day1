package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Courses;
import com.yo.day1.responsitory.CourseResponsitory;
import com.yo.day1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseResponsitory courseResponsitory;

    public List<Courses> findAll(){
        return courseResponsitory.findAll();
    }

    public Optional<Courses> findById(Long id){
        return courseResponsitory.findById(id);
    }

    public Courses save(Courses course){
        return courseResponsitory.save(course);
    }

    public Courses update(Long id, Courses course) {
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
