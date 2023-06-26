package com.tkn.crudangular.service;

import com.tkn.crudangular.model.Course;
import com.tkn.crudangular.repository.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    private final ICourseRepository _courseRepository;

    public CoursesService(ICourseRepository courseRepository) {
        _courseRepository = courseRepository;
    }

    public List<Course> getAll() {
        return _courseRepository.findAll();
    }

    public Course getById(Long id) {
        var course = _courseRepository.findById(id);

        return course.orElse(null);

    }

    public Course create(Course newCourse) {
        return _courseRepository.save(newCourse);
    }

    public void remove (Long id) {
        _courseRepository.deleteById(id);
    }
}
