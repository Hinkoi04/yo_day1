package com.yo.day1.dto.teacher;

import com.yo.day1.domain.enums.TeacherRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TeacherUpsertRequest {
    @NotBlank
    @Size(max = 20)
    private String teacherCode;

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotBlank
    @Pattern(regexp = "^(84|0[35789])+([0-9]{8})$")
    private String phone;

    @Email
    private String email;

    private TeacherRole teacherRole = TeacherRole.TEACHER;

    private String cccdImageUrl;

    private Boolean active = true;
}
