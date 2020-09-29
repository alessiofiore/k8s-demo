package com.example.k8s.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class K8sDemoController {

    @Autowired
    private GreetingConfig config;

    @Autowired
    private CustomConfig customConfig;


    @GetMapping(value = "/hello")
    public String hello() {
        return config.getMessage() + " " + customConfig.getName() + "!!";
    }
}
