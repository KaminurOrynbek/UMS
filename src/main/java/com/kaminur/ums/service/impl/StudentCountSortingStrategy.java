package com.kaminur.ums.service.impl;

import com.kaminur.ums.model.Course;
import com.kaminur.ums.service.SortingStrategy;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentCountSortingStrategy implements SortingStrategy {
    @Override
    public List<Course> sort(List<Course> courses) {
        return courses.stream()
                .sorted(Comparator.comparingInt(course -> course.getEnrollments().size()))
                .collect(Collectors.toList());
    }
}