package com.madkroll.demo.gradle.service;

import org.springframework.stereotype.Service;

@Service
public class JavaDemoService {

    public JavaDemoMessage buildMessage() {
        return new JavaDemoMessage("Java service");
    }
}