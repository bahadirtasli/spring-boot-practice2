package com.example.springbootpractice2.services;

import com.example.springbootpractice2.exceptions.TeacherNotFoundException;
import com.example.springbootpractice2.models.Teacher;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
public interface TeacherService {
    /**
     * To create a new teacher
     * @param teacher
     */
    void createTeacher(Teacher teacher);

    /**
     * To find a teacher by ID
     *
     * @param id Teacher ID
     * @return Teacher
     */
    Teacher findTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To find a teacher by name
     * @param name Teacher name
     * @return Teacher
     */
    Teacher findTeacherByName(String name) throws  TeacherNotFoundException;

    /**
     * To find all teachers
     * @return a list of Teachers
     */
    List<Teacher> findAllTeacher();

    /**
     * To update a Teacher
     * @param teacher
     */
    void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

    /**
     * To delete a Teacher by ID
     * @param id Teacher id
     */
    void deleteTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To restore a Teacher by ID
     * @param id Teacher id
     */
    void restoreTeacherById(Long id) throws TeacherNotFoundException;

}

