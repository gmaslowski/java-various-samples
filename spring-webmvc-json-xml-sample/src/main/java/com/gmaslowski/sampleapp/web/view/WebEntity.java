package com.gmaslowski.sampleapp.web.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gmaslowski.sampleapp.app.entity.AppEntity;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@JsonSerialize
@XmlRootElement
public class WebEntity {

    public static WebEntity fromAppEntity(AppEntity appEntity) {
        WebEntity webEntity = new WebEntity();
        webEntity.setName(appEntity.getName());
        webEntity.setValues(appEntity.getValues());
        return webEntity;
    }

    private String name;
    private List<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
