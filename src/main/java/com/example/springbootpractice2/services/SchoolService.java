package com.example.springbootpractice2.services;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.exceptions.SchoolNotFoundException;
import com.example.springbootpractice2.models.School;


import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
public interface SchoolService {

    /**
     * To create a new school
     *
     * @param school School
     */
    void createSchool(School school);

    /**
     * To find a school by ID
     * @param id School ID
     * @return School
     */
    School findSchoolById(Long id) throws SchoolNotFoundException;


    /**
     * To find a school by name
     * @param name School name
     * @return School
     */
    School findSchoolByName(String name) throws SchoolNotFoundException;

    /**
     * To find all schools
     *
     * @return a list of School
     */
    List<School> findAllSchools();


    /**
     * To update an existing School
     *
     * @param school School
     */
    void updateSchool(School school) throws SchoolNotFoundException;

    /**
     * To delete a School by ID
     * @param id School id
     */
    void deleteSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException;

    /**
     * To restore a School by ID
     * @param id School id
     */
    void restoreSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException;


}
