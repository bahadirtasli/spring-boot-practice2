package com.example.springbootpractice2.controllers;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.models.Course;
import com.example.springbootpractice2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/7/2023
 */

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/id")
    public ResponseEntity<?> findCourseById(@PathVariable long id) throws CourseNotFoundException {
        Course course = courseService.findCourseById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());
        return new ResponseEntity<>(course,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) throws CourseNotFoundException {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {

        try {
            Course searchCourse = courseService.findCourseByName(course.getName());
            throw new RuntimeException("Course already exists! Can not create this course!");
        } catch (CourseNotFoundException e) {
            courseService.createCourse(course);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) throws CourseNotFoundException {

        courseService.updateCourse(course);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCourse(@PathVariable Long id) throws CourseNotFoundException {
        courseService.restoreCourseById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
