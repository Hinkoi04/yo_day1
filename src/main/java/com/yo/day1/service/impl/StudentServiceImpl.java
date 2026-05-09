package com.yo.day1.service.impl;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.dto.parent.ParentRespone;
import com.yo.day1.dto.student.StudentResponse;
import com.yo.day1.dto.student.StudentUpserRequest;
import com.yo.day1.responsitory.ParentResponsitory;
import com.yo.day1.responsitory.StudentResponsitory;
import com.yo.day1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentResponsitory studentResponsitory;
    private final ParentResponsitory parentResponsitory;
    private final ModelMapper  mapper;

    private StudentResponse map(Student student) {
        return mapper.map(student, StudentResponse.class);
    }
    public List<StudentResponse> findByAll(){
        return studentResponsitory.findAll().stream()
                .map(s -> map(s))
                .toList();
    }
    public Optional<StudentResponse> findById(Long id){
        return studentResponsitory.findById(id)
                .map(this::map);
    }

    public StudentResponse create(StudentUpserRequest req){
        Student stu=mapper.map(req,Student.class);
        parentResponsitory.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setCreatedAt(LocalDateTime.now());
        stu.setUpdatedAt(LocalDateTime.now());
        Student result=studentResponsitory.save(stu);
        return map(result);
    }
    public StudentResponse update(Long id, StudentUpserRequest req){
        Student stu=mapper.map(req,Student.class);
        stu.setId(id);
        parentResponsitory.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setUpdatedAt(LocalDateTime.now());
        Student result=studentResponsitory.save(stu);
        return map(result);
    }

    public void delete(Long id) throws NotFoundException{
        if (studentResponsitory.existsById(id)){
            studentResponsitory.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }

    private StudentResponse map2(Student student){
        StudentResponse result = new StudentResponse();
        ParentRespone pResult = new ParentRespone();
        if (student.getParent() != null) {
            pResult.setId(student.getParent().getId());
            pResult.setFullName(student.getParent().getFullName());
            pResult.setGender(student.getParent().getGender());
            pResult.setPhone(student.getParent().getPhone());
            pResult.setEmail(student.getParent().getEmail());
            pResult.setAddress(student.getParent().getAddress());
            pResult.setRelationship(student.getParent().getRelationship());
        }
        result.setId(student.getId());
        result.setFullName(student.getFullName());
        result.setGender(student.getGender());
        result.setStudentCode(student.getStudentCode());
        result.setDateOfBirth(student.getDateOfBirth());
        result.setGradeLevel(student.getGradeLevel());
        result.setSchoolName(student.getSchoolName());
        result.setPhone(student.getPhone());
        result.setParent(pResult);
        result.setStatus(student.getStatus());
        result.setLatestScore(student.getLatestScore());
        result.setNote(student.getNote());
        result.setCreatedAt(student.getCreatedAt());
        result.setUpdatedAt(student.getUpdatedAt());

        return result;
    }
}
