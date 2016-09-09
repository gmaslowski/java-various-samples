package com.gmaslowski.sdfcp;

import lombok.Data;

import java.util.Date;

@Data
public class Event {

    Date created;
    Date processed;
}
