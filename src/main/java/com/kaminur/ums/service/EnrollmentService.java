package com.kaminur.ums.service;

import com.kaminur.ums.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO);
    EnrollmentDTO getEnrollment(Long id);
    List<EnrollmentDTO> getAllEnrollments();
    EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO);
    void deleteEnrollment(Long id);
}
