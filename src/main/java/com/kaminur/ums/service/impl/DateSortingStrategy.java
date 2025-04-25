package com.kaminur.ums.service.impl;

import com.kaminur.ums.model.Course;
import com.kaminur.ums.service.SortingStrategy;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DateSortingStrategy implements SortingStrategy {
    @Override
    public List<Course> sort(List<Course> courses) {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getStartDate))
                .collect(Collectors.toList());
    }
}