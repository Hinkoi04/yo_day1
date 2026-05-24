package com.yo.day1.service;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.CourseClass;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.dto.learningresult.LearningResultCreateRequest;
import com.yo.day1.dto.learningresult.LearningResultResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface LearningResultService {
    LearningResultResponse create(LearningResultCreateRequest request, String username);
    List<LearningResultResponse> findByStudentId(Long studentId, String username) throws BadRequestException, NotFoundException;
    Student getStudentForParent(Long studentId, Long parentId) throws NotFoundException;
    Student getStudent(Long id) throws NotFoundException;
    CourseClass getCourseClass(Long id) throws NotFoundException;
}
