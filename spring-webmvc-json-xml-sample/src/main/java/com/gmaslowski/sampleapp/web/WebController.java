package com.gmaslowski.sampleapp.web;

import static com.gmaslowski.sampleapp.web.view.WebEntity.fromAppEntity;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import com.gmaslowski.sampleapp.app.AppLogicService;
import com.gmaslowski.sampleapp.web.view.WebEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebController {

    @Autowired
    AppLogicService appLogicService;

    @RequestMapping(value = "entity", method = GET)
    public HttpEntity<WebEntity> entity() {
        WebEntity webEntity = fromAppEntity(appLogicService.getEntity());
        return new HttpEntity<>(webEntity);
    }

}
