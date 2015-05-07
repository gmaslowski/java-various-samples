package com.gmaslowski.sampleapp.jsf;

import static com.gmaslowski.sampleapp.web.view.WebEntity.fromAppEntity;
import com.gmaslowski.sampleapp.app.AppLogicService;
import com.gmaslowski.sampleapp.web.view.WebEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Scope("session")
public class JsfBean {

    @Autowired
    private AppLogicService appLogicService;

    private WebEntity webEntity;

    @PostConstruct
    public void loadMe() {
        this.webEntity = fromAppEntity(appLogicService.getEntity());
    }

    public WebEntity getWebEntity() {
        return webEntity;
    }
}
