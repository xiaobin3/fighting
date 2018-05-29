package com.xiaobin.example.springboot.message.test;

import com.xiaobin.example.springboot.message.ActiveMQQueueConst;
import com.xiaobin.example.springboot.message.ActiveMQQueueProducer;
import com.xiaobin.example.springboot.message.ActiveMQTopicConst;
import com.xiaobin.example.springboot.message.ActiveMQTopicPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 * @description 测试
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 */
@Component
@EnableScheduling
public class ActiveMQTest {

    @Autowired
    private ActiveMQQueueProducer activeMQQueueProducer;

    @Autowired
    private ActiveMQTopicPublisher activeMQTopicPublisher;

    @Scheduled(fixedRate = 10000, initialDelay = 3000)
    public void test() {
        activeMQQueueProducer.sendMsg(ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ,
                "队列message" + Instant.now().toString());
        activeMQTopicPublisher.publishMsg(ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE,
                "主题message" + Instant.now().toString());
    }

}
