package com.madkroll.demo.gradle.web

import com.madkroll.demo.gradle.service.KotlinDemoMessage
import com.madkroll.demo.gradle.service.KotlinDemoService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/kotlin")
@RestController
class KotlinDemoController constructor(
        private val demoService: KotlinDemoService
) {

    @RequestMapping("/demo")
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun handleRequest(): ResponseEntity<KotlinDemoMessage> {
        return ResponseEntity
                .ok()
                .body<KotlinDemoMessage>(demoService.buildMessage())
    }
}