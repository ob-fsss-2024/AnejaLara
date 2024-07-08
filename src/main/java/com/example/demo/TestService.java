package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TestService {
    private final String something;


    public TestService(@Value("${something.something}") String something) {
        this.something = something;
    }
    public String helloWorld(String name, String id) {
        return name + " " + id + something;
    }
}
