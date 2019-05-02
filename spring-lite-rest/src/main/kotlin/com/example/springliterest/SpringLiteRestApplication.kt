package com.example.springliterest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringLiteRestApplication {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }
}

fun main(args: Array<String>) {
    runApplication<SpringLiteRestApplication>(*args)
}
