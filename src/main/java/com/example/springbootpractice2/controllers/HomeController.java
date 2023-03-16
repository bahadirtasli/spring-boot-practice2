package com.example.springbootpractice2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Bahadir Tasli
 * @Date 3/16/2023
 */
@Controller
public class HomeController {
    @GetMapping
    public String showHomePage() {
        return "home";
    }
}
