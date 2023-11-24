package com.example.demo.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
