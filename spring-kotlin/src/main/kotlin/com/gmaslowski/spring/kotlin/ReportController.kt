package com.gmaslowski.spring.kotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

RestController
public class ReportController [Autowired](val reportService: ReportService) {

    RequestMapping(value = array("/report"), method = array(RequestMethod.GET))
    public fun someStat(): List<Data> = reportService.some()

}