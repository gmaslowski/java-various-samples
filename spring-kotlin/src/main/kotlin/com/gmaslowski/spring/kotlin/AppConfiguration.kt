package com.gmaslowski.spring.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import kotlin.platform.platformStatic

ComponentScan
EnableAutoConfiguration
EnableWebMvc
public class AppConfiguration {

    companion object {
        platformStatic public fun main(args: Array<String>) {
            SpringApplication.run(javaClass<AppConfiguration>(), *args)
        }
    }
}