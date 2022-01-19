package com.example.library.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContr {

    @GetMapping("/")
    public String hello() {return "Hello";};
}
