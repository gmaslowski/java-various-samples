package com.gmaslowski.sampleapp.app;

import com.gmaslowski.sampleapp.app.entity.AppEntity;
import org.springframework.stereotype.Service;

@Service
public class AppLogicService {

    public AppEntity getEntity() {
        return new AppEntity();
    }

}
