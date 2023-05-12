package com.filesMicroservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "<h1>Hola Mundo</h1>";
    }
}