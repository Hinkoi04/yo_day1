package com.yo.day1.service;

import com.yo.day1.domain.entity.Parents;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parents> findAll();
    Optional<Parents> findById(Long id);
    Parents save(Parents parents);
    Parents update(Long id, Parents parents);
    void delete(Long id);
}
