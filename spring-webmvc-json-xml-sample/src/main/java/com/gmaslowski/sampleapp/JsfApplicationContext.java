package com.gmaslowski.sampleapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.gmaslowski.sampleapp.jsf")
public class JsfApplicationContext {}
