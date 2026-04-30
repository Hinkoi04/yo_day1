package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Teachers;
import com.yo.day1.service.TeacherService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teachers>>> getTeachers() {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Teachers>> getTeacherById(@PathParam("id") Long id){
        Optional<Teachers> teachers = teacherService.findById(id);
        if(teachers.isPresent()){
            return ResponseEntity.ok(ApiResponse.success(teachers.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teachers>> create(@RequestBody Teachers teacher) {
        return ResponseEntity.ok(ApiResponse.success(teacherService.save(teacher)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Teachers>> update(@PathVariable("id") Long id, @RequestBody Teachers teacher) {
        try {
            Teachers  teachers = teacherService.update(id, teacher);
            return ResponseEntity.ok(ApiResponse.success(teacherService.update(id, teacher)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
