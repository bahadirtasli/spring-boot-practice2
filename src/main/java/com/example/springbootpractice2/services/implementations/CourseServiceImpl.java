package com.example.springbootpractice2.services.implementations;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.models.Course;
import com.example.springbootpractice2.models.School;
import com.example.springbootpractice2.services.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Override
    public void createCourse(Course course) {

    }

    @Override
    public Course findCourseById(Long id) throws CourseNotFoundException {
        return null;
    }

    @Override
    public Course findCourseByName(String name) throws CourseNotFoundException {
        return null;
    }

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public List<Course> findAllCoursesBySchool(School school) {
        return null;
    }

    @Override
    public void updateCourse(Course course) throws CourseNotFoundException {

    }

    @Override
    public void deleteCourseById(Long id) throws CourseNotFoundException {

    }

    @Override
    public void restoreCourseById(Long id) throws CourseNotFoundException {

    }
}
