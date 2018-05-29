package com.xiaobin.example.springboot.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 * ActiveMQ主题消息订阅者
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ActiveMQTopicSubscriber {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicSubscriber.class);

    @JmsListener(destination = ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, containerFactory = ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void subscribeTopicWebsocketSystemNoticeMsg(String message) {
        logger.info("消费了一条主题{}消息{}。", ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, message);
    }
}
