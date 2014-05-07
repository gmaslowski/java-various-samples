package com.gmaslowski.sampleapp.web.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@JsonSerialize
@XmlRootElement
public class AppEntity {

    private String name = "simpleName";
    private List<String> values = newArrayList("value1", "value2", "value3");

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
