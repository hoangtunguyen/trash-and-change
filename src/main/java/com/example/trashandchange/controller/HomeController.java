package com.example.trashandchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/products")
    public String products() {
        return "products";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
