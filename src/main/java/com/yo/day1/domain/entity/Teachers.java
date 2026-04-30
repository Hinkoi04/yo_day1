package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Teachers extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String teacherCode;

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(columnDefinition = "varchar(10)")
    private String phone;

    @Column(columnDefinition = "varchar(100)")
    private String email;

    @Column(columnDefinition = "varchar(50)")
    private String teacherRole;

    @Column(columnDefinition = "varchar(255)")
    private String cccdImageUrl;

    private byte isActive;
}
