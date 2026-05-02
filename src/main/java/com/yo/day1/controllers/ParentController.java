package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Parents;
import com.yo.day1.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parents>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Parents>> getById(@PathVariable("id") Long id) {
        return parentService.findById(id)
                .map(parent -> ResponseEntity.ok(ApiResponse.success(parent)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parents>> create(@RequestBody Parents parents) {
        return ResponseEntity.ok(ApiResponse.success(parentService.save(parents)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Parents>> update(@PathVariable("id") Long id, @RequestBody Parents parents) {
        try {
            return ResponseEntity.ok(ApiResponse.success(parentService.update(id, parents)));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) {
        try {
            parentService.delete(id);
            return ResponseEntity.ok(ApiResponse.success(null));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
