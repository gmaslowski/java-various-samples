package com.gmaslowski.spring.kotlin

import org.springframework.stereotype.Service

Service
public class ReportService {

    public fun some(): List<Data> {
        return listOf(Data(), Data(name = "BUT", id = 8))
    }

}
