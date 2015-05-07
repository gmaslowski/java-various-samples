package com.gmaslowski.sampleapp.jsf;

import static com.gmaslowski.sampleapp.web.view.WebEntity.fromAppEntity;
import com.gmaslowski.sampleapp.app.AppLogicService;
import com.gmaslowski.sampleapp.web.view.WebEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class JsfBean {

    @Autowired
    private AppLogicService appLogicService;

    public WebEntity loadMe() {
        return fromAppEntity(appLogicService.getEntity());
    }

}
