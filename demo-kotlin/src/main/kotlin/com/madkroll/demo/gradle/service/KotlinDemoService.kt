package com.madkroll.demo.gradle.service

import org.springframework.stereotype.Service

@Service
class KotlinDemoService {

    fun buildMessage(): KotlinDemoMessage {
        return KotlinDemoMessage("Kotlin service")
    }
}