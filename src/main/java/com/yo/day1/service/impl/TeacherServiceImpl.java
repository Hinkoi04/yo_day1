package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Teachers;
import com.yo.day1.responsitory.TeacherResponsitory;
import com.yo.day1.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherResponsitory teacherResponsitory;
    public TeacherServiceImpl(TeacherResponsitory teacherResponsitory) {
        this.teacherResponsitory = teacherResponsitory;
    }
    public List<Teachers>findAll(){
        return teacherResponsitory.findAll();
    }
    public Optional<Teachers> findById(Long id){
        return teacherResponsitory.findById(id);
    }
    public Teachers save(Teachers teachers) {
        return teacherResponsitory.save(teachers);
    }
    public Teachers update(Long id, Teachers details) {
        return teacherResponsitory.findById(id).map(existing -> {
            existing.setTeacherCode(details.getTeacherCode());
            existing.setFullName(details.getFullName());
            existing.setPhone(details.getPhone());
            existing.setEmail(details.getEmail());
            existing.setTeacherRole(details.getTeacherRole());
            existing.setCccdImageUrl(details.getCccdImageUrl());
            existing.setIsActive(details.getIsActive());
            return teacherResponsitory.save(existing);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy Giáo viên với ID: " + id));
    }
    public void delete(Long id){
        teacherResponsitory.deleteById(id);
    }
}
