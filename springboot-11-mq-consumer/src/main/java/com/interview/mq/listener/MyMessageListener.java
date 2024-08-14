package com.interview.mq.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/13 23:22
 */

@Component
@Slf4j
public class MyMessageListener {

    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";
    public static final String QUEUE_NAME = "queue.order";

    @RabbitListener(
            bindings = @QueueBinding(
                value = @Queue(value = QUEUE_NAME, durable = "true"),
                exchange = @Exchange(value = EXCHANGE_DIRECT),
                key = {ROUTING_KEY}))
    public void processMessage(String dateString, Message message, Channel channel) {
        log.info(dateString);
        log.info(new String(message.getBody()));
        log.info(message.getMessageProperties().toString());
    }
}
