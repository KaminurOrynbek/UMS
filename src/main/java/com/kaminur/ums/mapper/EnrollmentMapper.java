package com.kaminur.ums.mapper;

import com.kaminur.ums.dto.EnrollmentDTO;
import com.kaminur.ums.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDTO toDTO(Enrollment enrollment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    Enrollment toEntity(EnrollmentDTO enrollmentDTO);
}