package com.kaminur.ums.factory;

import com.kaminur.ums.dto.CourseDTO;
import com.kaminur.ums.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory {
    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setStartDate(courseDTO.getStartDate());
        return course;
    }
}