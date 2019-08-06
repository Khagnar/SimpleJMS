package jms.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.logging.Logger;

@org.springframework.stereotype.Controller
public class Controller {

    private Logger logger = Logger.getLogger("Controller");
    private AmqpTemplate amqpTemplate;

    @Autowired
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping("/send")
    @ResponseBody
    String queue() {
        logger.info("send to queue");
        for (int i = 0; i < 6; i++) {
            amqpTemplate.convertAndSend("queue_1", "message: "+ i);
        }
        return "send to queue";
    }
}
