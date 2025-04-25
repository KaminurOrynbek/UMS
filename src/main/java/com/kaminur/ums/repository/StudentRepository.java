package com.kaminur.ums.repository;

import com.kaminur.ums.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}