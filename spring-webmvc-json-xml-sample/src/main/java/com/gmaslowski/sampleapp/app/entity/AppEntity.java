package com.gmaslowski.sampleapp.app.entity;

import static com.google.common.collect.Lists.newArrayList;
import java.util.List;

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
