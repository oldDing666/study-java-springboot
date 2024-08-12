package com.interview.uv.count.jedis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.text.DecimalFormat;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/6 09:37
 */

public class UvTest {

    private Jedis jedis;
    private final String SET_KEY = "SET:PAGE1:2024-08-06";
    private final String PF_KEY = "PF:PAGE2:2024-08-06";
    private final long NUM = 10000 * 10L;

    @BeforeEach
    void connectToRedis() {
        jedis = new Jedis(new HostAndPort("localhost", 6379));
    }

    @Test
    void initData() {
        for (int i = 0; i < NUM; i++) {
            System.out.println(i);
            jedis.sadd(SET_KEY, "USER" + i);
            jedis.pfadd(PF_KEY, "USER" + i);
        }
    }

    @Test
    void getData() {
        long setCount = jedis.scard(SET_KEY);
        long pfCount = jedis.pfcount(PF_KEY);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00%");
        System.out.println(decimalFormat.format((double) setCount / (double) NUM));
        System.out.println(decimalFormat.format((double) pfCount / (double) NUM));
    }
}
