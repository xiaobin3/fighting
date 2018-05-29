package com.xiaobin.example.springboot.message;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *ActiveMQ主题常量
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class ActiveMQTopicConst {
    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "topicJmsListenerContainerFactory";

    /**
     * 主题消息标识_WebSocket的系统公告
     */
    public static final String TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE = "topic.websocket.system.notice";
}
