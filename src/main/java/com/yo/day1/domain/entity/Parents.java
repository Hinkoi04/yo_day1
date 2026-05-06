package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import com.yo.day1.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "parents")
public class Parents extends AuditableEntity {
    @Column(name = "full_name",nullable = false, length = 100)
    private String fullName;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 225)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender= Gender.OTHER;

    @Column(length = 50)
    private String relationship;
}
