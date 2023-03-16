package com.example.springbootpractice2.services.implementations;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.exceptions.StudentNotFoundException;
import com.example.springbootpractice2.models.Student;
import com.example.springbootpractice2.services.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Override
    public void createStudent(Student student) throws CourseNotFoundException {

    }

    @Override
    public Student findStudentById(Long id) throws StudentNotFoundException {
        return null;
    }

    @Override
    public Student findStudentByName(String name) throws StudentNotFoundException {
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public void updateStudent(Student student) throws StudentNotFoundException {

    }

    @Override
    public void deleteStudentById(Long id) throws StudentNotFoundException {

    }

    @Override
    public void restoreStudentById(Long id) throws StudentNotFoundException {

    }
}
