package com.ecomerce.rivopelus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestControllers {
    @GetMapping
    public String checkApi(){
        return "Hello";
    }
}
