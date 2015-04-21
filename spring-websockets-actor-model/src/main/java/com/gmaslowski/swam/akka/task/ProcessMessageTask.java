package com.gmaslowski.swam.akka.task;

import com.gmaslowski.swam.model.Message;

public class ProcessMessageTask {

    private Message message;

    public ProcessMessageTask(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
