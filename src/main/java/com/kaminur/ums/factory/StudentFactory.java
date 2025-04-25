package com.kaminur.ums.factory;

import com.kaminur.ums.dto.StudentDTO;
import com.kaminur.ums.model.Student;
import com.kaminur.ums.model.User;
import com.kaminur.ums.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {

    private final UserRepository userRepository;

    @Autowired
    public StudentFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        User user = userRepository.findById(studentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        student.setUser(user);
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }
}
