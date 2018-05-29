package com.xiaobin.example.springboot.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @description ActiveMQ消息队列配置类
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class ActiveMQConfiguration {

    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
