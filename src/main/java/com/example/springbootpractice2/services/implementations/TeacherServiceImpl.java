package com.example.springbootpractice2.services.implementations;

import com.example.springbootpractice2.exceptions.TeacherNotFoundException;
import com.example.springbootpractice2.models.Teacher;
import com.example.springbootpractice2.services.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Override
    public void createTeacher(Teacher teacher) {

    }

    @Override
    public Teacher findTeacherById(Long id) throws TeacherNotFoundException {
        return null;
    }

    @Override
    public Teacher findTeacherByName(String name) throws TeacherNotFoundException {
        return null;
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return null;
    }

    @Override
    public void updateTeacher(Teacher teacher) throws TeacherNotFoundException {

    }

    @Override
    public void deleteTeacherById(Long id) throws TeacherNotFoundException {

    }

    @Override
    public void restoreTeacherById(Long id) throws TeacherNotFoundException {

    }
}
