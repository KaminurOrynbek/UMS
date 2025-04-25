package com.kaminur.ums.factory;

import com.kaminur.ums.dto.EnrollmentDTO;
import com.kaminur.ums.model.Course;
import com.kaminur.ums.model.Enrollment;
import com.kaminur.ums.model.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentFactory {

    public Enrollment createEnrollment(EnrollmentDTO enrollmentDTO, Student student, Course course) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentDTO.getEnrollmentDate());
        return enrollment;
    }
}
