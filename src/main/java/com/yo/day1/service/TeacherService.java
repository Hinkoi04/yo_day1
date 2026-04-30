package com.yo.day1.service;

import com.yo.day1.domain.entity.Teachers;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teachers> findAll();
    Optional<Teachers> findById(Long id);
    Teachers save(Teachers teachers);
    Teachers update(Long id, Teachers details);
    void delete(Long id);
}
