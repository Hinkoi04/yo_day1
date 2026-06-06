package com.yo.day1.repository;

import com.yo.day1.domain.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parents,Long> {
}
