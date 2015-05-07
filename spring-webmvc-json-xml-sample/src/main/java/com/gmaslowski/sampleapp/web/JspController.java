package com.gmaslowski.sampleapp.web;

import static com.gmaslowski.sampleapp.web.view.WebEntity.fromAppEntity;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import com.gmaslowski.sampleapp.app.AppLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @Autowired
    AppLogicService appLogicService;

    @RequestMapping(method = GET)
    public String getEntity(ModelMap model) {
        model.addAttribute("entity", fromAppEntity(appLogicService.getEntity()));
        return "list";

    }

}
