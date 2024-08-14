package com.interview.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void producerTest() {
        rabbitTemplate.convertAndSend(
                EXCHANGE_DIRECT, ROUTING_KEY, "Hello afu!!!!!");
    }
}
