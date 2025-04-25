package com.kaminur.ums.service;

import com.kaminur.ums.model.Course;

import java.util.List;

public interface SortingStrategy {
    List<Course> sort(List<Course> courses);
}