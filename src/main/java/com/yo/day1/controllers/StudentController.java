package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.dto.student.StudentResponse;
import com.yo.day1.dto.student.StudentUpserRequest;
import com.yo.day1.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll(){
        return ResponseEntity.ok(studentService.findByAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id){
        return studentService.findById(id)
                .map(stu-> ResponseEntity.ok(stu))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentUpserRequest req){
        return ResponseEntity.ok(studentService.create(req));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<StudentResponse> update(@PathVariable Long id, StudentUpserRequest req){
        return ResponseEntity.ok(studentService.update(id, req));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
