package com.gmaslowski.sampleapp.web;

import com.gmaslowski.sampleapp.web.view.AppEntity;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping(value = "entity", method = GET)
    public @ResponseBody HttpEntity<AppEntity> entity() {
        return new HttpEntity<>(new AppEntity());
    }

}
