package com.example.springbootpractice2.components;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.exceptions.SchoolNotFoundException;
import com.example.springbootpractice2.exceptions.StudentNotFoundException;
import com.example.springbootpractice2.exceptions.TeacherNotFoundException;
import com.example.springbootpractice2.models.*;
import com.example.springbootpractice2.services.CourseService;
import com.example.springbootpractice2.services.SchoolService;
import com.example.springbootpractice2.services.StudentService;
import com.example.springbootpractice2.services.TeacherService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;


/**
 * Component to Inıtialized data an application startup
 *
 * @author Bahadir Tasli
 * @Date 2/27/2023
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;




    @PostConstruct
    public void init() {
        initSchool();
        initCourse();
        initTeacher();
        initStudent();
    }



    // PRIVATE METHODS //
    private void initSchool() {
        System.out.println("Starting school initialization..");
        School school = new School();
        school.setName("Tartu University");
        school.setAddress("Ulikooli 18, Tartu");
        school.setPhone("+372 55555555");

        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Can not pre-initialize school :" + school.getName());
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }



    private void initCourse() {
        System.out.println("Starting course initialization");

        try {
            School searchSchool = schoolService.findSchoolByName("Tartu University");
            Course course = new Course();
            course.setName("Maths");
            course.setSchool(searchSchool);
            course.setStartDate(LocalDate.now());
            course.setDurationInDays(100);

            try {
                Course searchCourse = courseService.findCourseByName(course.getName());
                System.out.println("Cannot pre-initialize course : " + course.getName());
            } catch (CourseNotFoundException e) {
                courseService.createCourse(course);

            }
            Course course1 = new Course();
            course1.setName("Science");
            course1.setSchool(searchSchool);
            course1.setStartDate(LocalDate.now());
            course1.setDurationInDays(100);

        } catch (SchoolNotFoundException e) {
            System.out.println("Cannot pre-initialize course! Reason :  " + e.getLocalizedMessage());

        }


    }

    private void initTeacher(){
        System.out.println("Starting teacher initialization");


        try {
            Course course = courseService.findCourseByName("Maths");
            Course course1 = courseService.findCourseByName("Science");
            Teacher teacher = new Teacher();
            teacher.setName("Vinod");
            teacher.setGender(Gender.MALE);
            teacher.setEmail("vinod@gmail.com");
            teacher.setSpecializedCourses(Arrays.asList(course,course1));

            try {
                Teacher searchTeacher = teacherService.findTeacherByName(teacher.getName());
                System.out.println("CaN not pre-initialize teacher : " + teacher.getName());
            } catch (TeacherNotFoundException e) {
                teacherService.createTeacher(teacher);
            }
        } catch (CourseNotFoundException e) {
            System.out.println("Cannot pre-initialize teacher! Reason :  " + e.getLocalizedMessage());
        }
    }



    private void initStudent() {
        System.out.println("Starting student initialization");

        try {
            Course course = courseService.findCourseByName("Maths");

            Student student = new Student();
            student.setName("Bahadir");
            student.setAge(30);
            student.setEmail("bahadir@gmail.com");
            student.setGrade(4);
            student.setGender(Gender.MALE);
            student.setCourses(Collections.singletonList(course));
            try {
                Student searchStudent = studentService.findStudentByName(student.getName());
                System.out.println("Can not pre-initialize student " + student.getName());
            } catch (StudentNotFoundException e) {
                studentService.createStudent(student);
            }

        } catch (CourseNotFoundException e) {
            System.out.println("Cannot pre-initialize student! Reason :  " + e.getLocalizedMessage());
        }

    }

}
