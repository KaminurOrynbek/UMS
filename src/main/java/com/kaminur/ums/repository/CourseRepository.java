package com.kaminur.ums.repository;

import com.kaminur.ums.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}