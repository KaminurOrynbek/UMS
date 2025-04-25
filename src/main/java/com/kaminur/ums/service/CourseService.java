package com.kaminur.ums.service;

import com.kaminur.ums.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO getCourse(Long id);
    List<CourseDTO> getAllCourses(String sortBy);
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
}