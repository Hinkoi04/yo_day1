package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.dto.attendance.AttendanceCreateRequest;
import com.yo.day1.dto.attendance.AttendanceResponse;
import com.yo.day1.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<AttendanceResponse> create(@Valid @RequestBody AttendanceCreateRequest request, Principal principal) throws BadRequestException {
        return ApiResponse.success("Attendance created", attendanceService.create(request, principal.getName()));
    }

    @GetMapping("/class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<List<AttendanceResponse>> findByClassId(@PathVariable Long classId) {
        return ApiResponse.success(attendanceService.findByClassId(classId));
    }
}
