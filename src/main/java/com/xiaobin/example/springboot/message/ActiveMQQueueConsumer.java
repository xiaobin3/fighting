package com.xiaobin.example.springboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 * @description ActiveMQ队列消息消费者
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 */
@Component
public class ActiveMQQueueConsumer {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQQueueConsumer.class);

    /**
     * WebSocket的Java老司机聊天室队列消息消费者
     */
    @JmsListener(destination = ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, containerFactory = ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void receiveQueueWebSocketJavalsjChatroomMsg(String message) {
        logger.info("消费了一条队列{}消息{}。", ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, message);
    }

}