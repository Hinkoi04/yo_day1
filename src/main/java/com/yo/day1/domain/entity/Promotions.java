package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class Promotions extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String promoCode;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "varchar(20)")
    private String discountType;
    private Double discountValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private byte isActive;
    @Column(columnDefinition = "text")
    private String note;
}
