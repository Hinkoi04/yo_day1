package com.yo.day1.service.impl;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.CourseClass;
import com.yo.day1.dto.courseclass.CourseClassResponse;
import com.yo.day1.dto.courseclass.CourseClassUpsertRequest;
import com.yo.day1.repository.*;
import com.yo.day1.service.CourseClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesClassServiceImpl implements CourseClassService {
    private final CoursesClassRepository coursesClassRepository;
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final CourseResponsitory courseResponsitory;
    private final TeacherResponsitory teacherResponsitory;

    private final ModelMapper mapper;
    private final RoomRepository roomRepository;

    CourseClassResponse toCourseClassResponse(CourseClass cc){
        return mapper.map(cc, CourseClassResponse.class);
    }
    public List<CourseClassResponse> findAll() {
        return coursesClassRepository.findAll().stream()
                .map(this::toCourseClassResponse)
                .toList();
    }

    public Optional<CourseClassResponse>  findById(Long id) {
        return coursesClassRepository.findById(id)
                .map(this::toCourseClassResponse);
    }

    public CourseClassResponse create(CourseClassUpsertRequest req){
        CourseClass cc = mapper.map(req, CourseClass.class);
        if(req.getCourseId()!=null){
            courseResponsitory.findById(req.getCourseId()).ifPresent(cc::setCourses);
        }
        if (req.getScheduleSlotId()!=null){
            scheduleSlotRepository.findById(req.getScheduleSlotId()).ifPresent(cc::setScheduleSlots);
        }
        if(req.getRoomId()!=null){
            roomRepository.findById(req.getRoomId()).ifPresent(cc::setRoom);
        }
        if (req.getMainTeacherId()!=null){
            teacherResponsitory.findById(req.getMainTeacherId()).ifPresent(cc::setMainTeacher);
        }
        if(req.getAssistantTeacherId()!=null){
            teacherResponsitory.findById(req.getAssistantTeacherId()).ifPresent(cc::setAssistantTeacher);
        }

        CourseClass result = coursesClassRepository.save(cc);
        return toCourseClassResponse(result);
    }

    public CourseClassResponse update(Long id, CourseClassUpsertRequest req){
        Optional<CourseClass> courseClass = coursesClassRepository.findById(id);
        if (courseClass.isPresent()) {
            CourseClass cc = courseClass.get();
            if (req.getCourseId() != null) {
                courseResponsitory.findById(req.getCourseId()).ifPresent(cc::setCourses);
            }

            if (req.getCourseId() != null) {
                courseResponsitory.findById(req.getCourseId()).ifPresent(cc::setCourses);
            }
            if (req.getScheduleSlotId() != null) {
                scheduleSlotRepository.findById(req.getScheduleSlotId()).ifPresent(cc::setScheduleSlots);
            }
            if (req.getRoomId() != null) {
                roomRepository.findById(req.getRoomId()).ifPresent(cc::setRoom);
            }
            if (req.getMainTeacherId() != null) {
                teacherResponsitory.findById(req.getMainTeacherId()).ifPresent(cc::setMainTeacher);
            }
            if (req.getAssistantTeacherId() != null) {
                teacherResponsitory.findById(req.getAssistantTeacherId()).ifPresent(cc::setAssistantTeacher);
            }

            CourseClass result = coursesClassRepository.save(cc);
            return toCourseClassResponse(result);
        }else {
            throw new NotFoundException("CoursesClass not Exists");
        }
    }
    @Transactional(readOnly = true)
    public CourseClass getCourseClass(Long id) {
        return coursesClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course class not found: " + id));
    }

}
