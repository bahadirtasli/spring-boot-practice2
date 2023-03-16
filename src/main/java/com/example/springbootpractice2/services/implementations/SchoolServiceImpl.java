package com.example.springbootpractice2.services.implementations;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.exceptions.SchoolNotFoundException;
import com.example.springbootpractice2.models.School;
import com.example.springbootpractice2.services.SchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Override
    public void createSchool(School school) {

    }

    @Override
    public School findSchoolById(Long id) throws SchoolNotFoundException {
        return null;
    }

    @Override
    public School findSchoolByName(String name) throws SchoolNotFoundException {
        return null;
    }

    @Override
    public List<School> findAllSchools() {
        return null;
    }

    @Override
    public void updateSchool(School school) throws SchoolNotFoundException {

    }

    @Override
    public void deleteSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException {

    }

    @Override
    public void restoreSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException {

    }
}
