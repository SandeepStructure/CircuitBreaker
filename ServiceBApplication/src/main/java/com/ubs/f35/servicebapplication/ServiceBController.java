package com.ubs.f35.servicebapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Service B";
    }
}