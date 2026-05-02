package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Parents;
import com.yo.day1.responsitory.ParentResponsitory;
import com.yo.day1.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentResponsitory parentRespository;

    public ParentServiceImpl(ParentResponsitory parentRespository) {
        this.parentRespository = parentRespository;
    }

    public List<Parents> findAll() { return parentRespository.findAll(); }

    public Optional<Parents> findById(Long id) { return parentRespository.findById(id); }

    public Parents save(Parents parent) { return parentRespository.save(parent); }

    public Parents update(Long id, Parents details) {
        return parentRespository.findById(id).map(existing -> {
            existing.setFullName(details.getFullName());
            existing.setPhone(details.getPhone());
            existing.setEmail(details.getEmail());
            existing.setAddress(details.getAddress());
            return parentRespository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy Phụ huynh với ID: " + id));
    }

    public void delete(Long id) {
        parentRespository.deleteById(id);
    }
}
