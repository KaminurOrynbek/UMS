package com.kaminur.ums.service.impl;

import com.kaminur.ums.dto.CourseDTO;
import com.kaminur.ums.exception.ResourceNotFoundException;
import com.kaminur.ums.factory.CourseFactory;
import com.kaminur.ums.mapper.CourseMapper;
import com.kaminur.ums.model.Course;
import com.kaminur.ums.repository.CourseRepository;
import com.kaminur.ums.service.CourseService;
import com.kaminur.ums.service.SortingStrategy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final Map<String, SortingStrategy> sortingStrategies;
    private final CourseFactory courseFactory;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper,
                             Map<String, SortingStrategy> sortingStrategies, CourseFactory courseFactory) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.sortingStrategies = sortingStrategies;
        this.courseFactory = courseFactory;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = courseFactory.createCourse(courseDTO);
        course = courseRepository.save(course);
        return courseMapper.toDTO(course);
    }

    @Override
    public CourseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return courseMapper.toDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses(String sortBy) {
        List<Course> courses = courseRepository.findAll();
        if (sortBy != null && sortingStrategies.containsKey(sortBy)) {
            courses = sortingStrategies.get(sortBy).sort(courses);
        }
        return courses.stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setName(courseDTO.getName());
        course.setStartDate(courseDTO.getStartDate());
        course = courseRepository.save(course);
        return courseMapper.toDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseRepository.delete(course);
    }
}