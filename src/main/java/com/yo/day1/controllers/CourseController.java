package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Courses;
import com.yo.day1.service.CourseService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Courses>>> getCourse(){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Courses>> getCourseById(@PathParam("id") Long id){

//        return courseService.findById(id).map(value ->
//                        ResponseEntity.ok(ApiResponse.success(value)))
//                .orElseGet(() -> ResponseEntity.notFound().build());


        Optional<Courses> course = courseService.findById(id);
        if(course.isPresent()){
            return ResponseEntity.ok(ApiResponse.success(course.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> create(@RequestBody Courses course){
        return ResponseEntity.ok(ApiResponse.success(courseService.save(course)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> update(@PathVariable("id") Long id , @RequestBody Courses course){
        try{
            Courses update= courseService.update(id,course);
            return ResponseEntity.ok(ApiResponse.success(update));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> delete(@PathVariable("id") Long id){
        courseService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
