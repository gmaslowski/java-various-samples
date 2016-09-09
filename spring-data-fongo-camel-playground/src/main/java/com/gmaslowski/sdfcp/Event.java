package com.gmaslowski.sdfcp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Event {

    @Id
    String id;
    Date created;
    Date processed;
}
