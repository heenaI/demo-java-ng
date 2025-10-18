package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class HomeController {
    @GetMapping("/")
    public String home() {
        return new String("Welcome to Employee Management System");
    }
    
    
}
