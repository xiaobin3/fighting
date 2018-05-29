package com.xiaobin.example.springboot.message;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *ActiveMQ队列常量
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class ActiveMQQueueConst {
    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "queueJmsListenerContainerFactory";

    /**
     * 队列消息标识_WebSocket的Java老司机聊天室
     */
    public static final String QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ = "queue.websocket.chatroom.javalsj";
}
