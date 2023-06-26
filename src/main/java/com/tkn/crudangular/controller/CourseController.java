package com.tkn.crudangular.controller;

import com.tkn.crudangular.model.Course;
import com.tkn.crudangular.repository.ICourseRepository;
import com.tkn.crudangular.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CoursesService service;

    public CourseController(CoursesService coursesService) {
        this.service = coursesService;
    }

    @GetMapping
    public List<Course> list () {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return service.create(course);
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    @GetMapping("{id}")
    public Optional<Course> getById(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Esse é o valor do Id" + id);
        //var deletedCourse = courseRepository.findById(id);

        courseRepository.deleteById(id);

        return;
    }
}
