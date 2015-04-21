package com.gmaslowski.swam.web;

import com.gmaslowski.swam.akka.task.ProcessMessageTask;
import com.gmaslowski.swam.model.Message;
import com.gmaslowski.swam.model.OutputMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import akka.actor.ActorRef;
import java.util.Date;

@Controller
@RequestMapping("/")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    ActorRef processMessageActor;

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public OutputMessage handleMessage(Message message) {

        processMessageActor.tell(new ProcessMessageTask(message), null);

        return new OutputMessage(message, new Date());
    }
}
