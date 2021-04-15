package com.cjt.desigmode.composite.message;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式。
 * 例子：发送sms、qq、wechat消息。可以组合发送，也可以单个发送。
 */
public class MessageCompositeMain {

    public static void main(String[] args) {
        MessageContainer messageContainer = new MessageContainer();
        messageContainer.add(new Qq("alun", "你好，请回复我好吗？"));
        messageContainer.add(new Wechat("张三", "今天吃鸡！"));

        messageContainer.sendMessage();
    }

}

//组合接口
interface IMessageComponent {
    void sendMessage();

    default void add(IMessageComponent messageComponent) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("无实现");
    }

    default void remove(IMessageComponent messageComponent) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("无实现");
    }
}

//消息容器，节点
class MessageContainer implements IMessageComponent{
    private List<IMessageComponent> messageComponents = new ArrayList<>();

    public void add(IMessageComponent messageComponent){
        messageComponents.add(messageComponent);
    }

    public void remove(IMessageComponent messageComponent){
        messageComponents.remove(messageComponent);
    }

    @Override
    public void sendMessage() {
        for(var item: messageComponents)
            item.sendMessage();
    }
}

//sms
class Sms implements IMessageComponent{

    private String user;
    private String message;
    public Sms(String user, String message){
        this.user = user;
        this.message = message;
    }

    @Override
    public void sendMessage() {
        System.out.println("发送sms消息给"+user + "，消息是：" + message);
    }
}

//QQ
class Qq implements IMessageComponent {

    private String user;
    private String message;
    public Qq(String user, String message){
        this.user = user;
        this.message = message;
    }

    @Override
    public void sendMessage() {
        System.out.println("发送qq消息给"+user + "，消息是：" + message);
    }
}

//wechat
class Wechat implements IMessageComponent{

    private String user;
    private String message;
    public Wechat(String user, String message){
        this.user = user;
        this.message = message;
    }

    @Override
    public void sendMessage() {
        System.out.println("发送wechat消息给"+user + "，消息是：" + message);
    }
}