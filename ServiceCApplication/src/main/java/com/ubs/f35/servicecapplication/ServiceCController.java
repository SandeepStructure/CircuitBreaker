package com.ubs.f35.servicecapplication;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceCController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-service-b")
    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallbackMethod")
    public String callServiceB() {
        String url = "http://service-b/hello";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackMethod(Throwable throwable) {
        return "Service B is currently unavailable. Please try again later.";
    }
}