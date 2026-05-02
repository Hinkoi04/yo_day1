package com.yo.day1.responsitory;

import com.yo.day1.domain.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentResponsitory extends JpaRepository<Parents,Long> {
}
