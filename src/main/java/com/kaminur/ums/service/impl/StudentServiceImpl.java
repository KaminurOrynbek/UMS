package com.kaminur.ums.service.impl;

import com.kaminur.ums.dto.StudentDTO;
import com.kaminur.ums.exception.ResourceNotFoundException;
import com.kaminur.ums.factory.StudentFactory;
import com.kaminur.ums.model.Student;
import com.kaminur.ums.repository.StudentRepository;
import com.kaminur.ums.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentFactory studentFactory;

    public StudentServiceImpl(StudentRepository studentRepository, StudentFactory studentFactory) {
        this.studentRepository = studentRepository;
        this.studentFactory = studentFactory;
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setUserId(student.getUser().getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentFactory.createStudent(studentDTO);
        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    @Override
    public StudentDTO getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return convertToDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());

        student = studentRepository.save(student);

        return convertToDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepository.delete(student);
    }
}
