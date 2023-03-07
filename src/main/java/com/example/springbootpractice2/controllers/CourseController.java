package com.example.springbootpractice2.controllers;

import com.example.springbootpractice2.exceptions.CourseNotFoundException;
import com.example.springbootpractice2.exceptions.SchoolNotFoundException;
import com.example.springbootpractice2.models.Course;
import com.example.springbootpractice2.models.School;
import com.example.springbootpractice2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Bahadir Tasli
 * @Date 3/7/2023
 */

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public String showSchoolListPage(Model model, @ModelAttribute("message") String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("courses",courseService.findAllCourses());
        return "course/list-course";

    }

    @GetMapping("/id")
    public String showCourseViewPage(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
    try {
        model.addAttribute("course",courseService.findCourseById(id));
        return "course/view-course";
    } catch (CourseNotFoundException e) {
        return handleException(redirectAttributes, e);
    }
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        try {
            courseService.deleteCourseById(id);
            redirectAttributes.addFlashAttribute("message", String.format("Course #%d deleted succesfully", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/course";
        } catch (CourseNotFoundException e) {
            return handleException(redirectAttributes, e);
        }

    }

    @GetMapping("/create")
    public String showCreateCoursePage(@ModelAttribute("course")Course course,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "course/create-course";
    }

    @PostMapping
    public String createCourse(Course course, RedirectAttributes redirectAttributes) {

        try {
            Course searchCourse = courseService.findCourseByName(course.getName());
            redirectAttributes.addFlashAttribute("message",String.format("Course(%s) already exist",course.getName()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/course/create-course";
        } catch (CourseNotFoundException e) {
            courseService.createCourse(course);
            redirectAttributes.addFlashAttribute("message",String.format("Course(%s) has been created successfully!",course.getName()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/course";
        }
    }
    @GetMapping("/update/{id}")
    public String showUpdateCoursePage(@PathVariable Long id,
                                       RedirectAttributes redirectAttributes,
                                       @RequestParam(value = "course",required = false) Course course,
                                       Model model) {
        if (course == null) {
            try {
                model.addAttribute("course",courseService.findCourseById(id));
            } catch (CourseNotFoundException e) {
                return handleException(redirectAttributes,e);
            }
        }
        return "course/update-course";
    }

    @PostMapping("/update")
    public String updateCourse(Course course,RedirectAttributes redirectAttributes) {
        try {
            courseService.updateCourse(course);
            redirectAttributes.addFlashAttribute("message",String.format("Course (id=%d) has been updated successfully", course.getId()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/course";
        } catch (CourseNotFoundException e) {
            return handleException(redirectAttributes,e);
        }
    }

    @GetMapping("/restore/{id}")
    public String restoreCourse(@PathVariable Long id,RedirectAttributes redirectAttributes){
        try {
            courseService.restoreCourseById(id);
            redirectAttributes.addFlashAttribute("message",String.format("Course #%d restored successfully", id));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/course";
        } catch (CourseNotFoundException e) {
            return handleException(redirectAttributes,e);
        }
    }
    private static String handleException(RedirectAttributes redirectAttributes, Exception e) {
        redirectAttributes.addFlashAttribute("message", e.getLocalizedMessage());
        redirectAttributes.addFlashAttribute("messageType","error");
        return "redirect:/course";
    }

}
