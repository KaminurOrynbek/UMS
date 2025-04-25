package com.kaminur.ums.service.impl;

import com.kaminur.ums.dto.EnrollmentDTO;
import com.kaminur.ums.exception.ResourceNotFoundException;
import com.kaminur.ums.factory.EnrollmentFactory;
import com.kaminur.ums.mapper.EnrollmentMapper;
import com.kaminur.ums.model.Course;
import com.kaminur.ums.model.Enrollment;
import com.kaminur.ums.model.Student;
import com.kaminur.ums.repository.CourseRepository;
import com.kaminur.ums.repository.EnrollmentRepository;
import com.kaminur.ums.repository.StudentRepository;
import com.kaminur.ums.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final EnrollmentFactory enrollmentFactory;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentRepository studentRepository,
                                 CourseRepository courseRepository,
                                 EnrollmentMapper enrollmentMapper,
                                 EnrollmentFactory enrollmentFactory) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentMapper = enrollmentMapper;
        this.enrollmentFactory = enrollmentFactory;
    }

    @Override
    public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO) {
        Student student = studentRepository.findById(enrollmentDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(enrollmentDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = enrollmentFactory.createEnrollment(enrollmentDTO, student, course);
        enrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDTO(enrollment);
    }

    @Override
    public EnrollmentDTO getEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        return enrollmentMapper.toDTO(enrollment);
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        Student student = studentRepository.findById(enrollmentDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(enrollmentDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentDTO.getEnrollmentDate());

        enrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDTO(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }
}
