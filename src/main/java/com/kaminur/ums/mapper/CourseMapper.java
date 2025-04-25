package com.kaminur.ums.mapper;

import com.kaminur.ums.dto.CourseDTO;
import com.kaminur.ums.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO courseDTO);
}