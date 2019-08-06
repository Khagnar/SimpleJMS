package jms;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class RabbitListeners {
    private Logger logger = Logger.getLogger("RabbitListeners");

    @RabbitListener(queues = "queue_1")
    public void listenerOne(String message) {
        logger.info("Listener 1: " + message);
        try {
            Thread.sleep((int)(Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "queue_1")
    public void listenerTwo(String message) {
        logger.info("Listener 2: " + message);
        try {
            Thread.sleep((int)(Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
