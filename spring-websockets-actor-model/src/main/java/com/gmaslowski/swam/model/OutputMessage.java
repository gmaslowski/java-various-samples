package com.gmaslowski.swam.model;

import java.util.Date;

public class OutputMessage extends Message {

    private Date created;

    public OutputMessage(Message message, Date created) {
        super(message);
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
