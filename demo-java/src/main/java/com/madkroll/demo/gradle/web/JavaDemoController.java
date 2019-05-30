package com.madkroll.demo.gradle.web;

import com.madkroll.demo.gradle.service.JavaDemoMessage;
import com.madkroll.demo.gradle.service.JavaDemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/java")
@RestController
@Log4j2
public class JavaDemoController {

    private final JavaDemoService demoService;

    public JavaDemoController(final JavaDemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/demo")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JavaDemoMessage> handleRequest() {
        return ResponseEntity
                .ok()
                .body(demoService.buildMessage());
    }
}