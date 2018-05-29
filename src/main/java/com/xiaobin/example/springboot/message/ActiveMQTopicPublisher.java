package com.xiaobin.example.springboot.message;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 * ActiveMQ主题消息发布者
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ActiveMQTopicPublisher {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicPublisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发布主题消息
     */
    public void publishMsg(String destinationName, String message) {
        logger.info("发布了一条主题{}消息{}。", destinationName, message);
        Destination destination = new ActiveMQTopic(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
