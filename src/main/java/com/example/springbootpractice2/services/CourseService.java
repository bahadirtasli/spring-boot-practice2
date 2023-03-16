package com.example.springbootpractice2.services;
import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.models.Course;
import com.example.springbootpractice2.models.School;

import java.util.List;

public interface CourseService {

    /**
     * To create a new course
     *
     * @param course Course
     */
    void createCourse(Course course);

    /**
     * To find a course by ID
     *
     * @param id Course ID
     * @return Course
     */
    Course findCourseById(Long id) throws CourseNotFoundException;

    /**
     * To find a course by Name
     *
     * @param name Course name
     * @return Course
     */

    Course findCourseByName(String name) throws CourseNotFoundException;

    /**
     * To find all courses
     *
     * @return a list of Course
     */
    List<Course> findAllCourses();

    /**
     * To find all courses by School
     *
     * @param school School
     * @return
     */
    List<Course> findAllCoursesBySchool(School school);

    /**
     * To update an existing Course
     *
     * @param course Course
     */
    void updateCourse(Course course) throws CourseNotFoundException;

    /**
     * To delete a Course by ID
     *
     * @param id Course id
     */
    void deleteCourseById(Long id) throws CourseNotFoundException;

    /**
     * To restore a Course by ID
     *
     * @param id Course id
     */
    void restoreCourseById(Long id) throws CourseNotFoundException;


}