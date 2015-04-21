package com.gmaslowski.swam.model;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Message {

    public Message() {}

    private String id;
    private String text;

    public Message(Message message) {
        this.id = message.getId();
        this.text = message.getText();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return toStringHelper(Message.class)
            .add("id", id)
            .add("text", text)
            .toString();
    }
}
