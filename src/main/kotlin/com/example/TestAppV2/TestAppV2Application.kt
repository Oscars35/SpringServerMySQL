package com.example.TestAppV2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.example.TestAppV2"])
class TestAppV2Application

fun main(args: Array<String>) {
	SpringApplication.run(TestAppV2Application::class.java, *args)
}
