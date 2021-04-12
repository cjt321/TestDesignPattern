package com.cjt.desigmode.bridge.messagedemonew;

/**
 * 桥接模式，
 *
 */
public class BridgeMainMessageDemoNew {
    public static void main(String[] args) {
        System.out.println("---BridgeMainMessageDemoNew---");
        new CommonMessageMode(new PhoneMessageType()).send("alun", "马上联系我");
        new UrgencyMessageMode(new PhoneMessageType()).send("alun", "没听到吗？马上联系我！");
        new CommonMessageMode(new EmailMessageType()).send("洪兴", "关于龙头棍的消息");
        new ExtraUrgentMessageMode(new PhoneMessageType()).send("东星", "关于龙头棍的消息");
    }
}

//消息类型
interface IMessageType{
    void send(String user, String message);
}

//电话消息类型
class PhoneMessageType implements IMessageType{

    @Override
    public void send(String user, String message) {
        System.out.println(user + "发送电话消息：" + message);
    }
}

//email消息类型
class EmailMessageType implements IMessageType{

    @Override
    public void send(String user, String message) {
        System.out.println(user + "发送Email消息：" + message);
    }
}

//消息重要方式
abstract class AbsMessageMode{
    protected IMessageType messageType;

    public AbsMessageMode(IMessageType messageType){
        this.messageType = messageType;
    }

    public void send(String user, String message){
        messageType.send(user, message);
    }
}

//普通消息模式
class CommonMessageMode extends AbsMessageMode{

    public CommonMessageMode(IMessageType messageType) {
        super(messageType);
    }

    @Override
    public void send(String user, String message) {
        super.send(user, message);
        System.out.println("---发送普通消息---");
    }
}

//紧急消息模式
class UrgencyMessageMode extends AbsMessageMode{

    public UrgencyMessageMode(IMessageType messageType) {
        super(messageType);
    }

    @Override
    public void send(String user, String message) {
        super.send(user, message);
        System.out.println("---发送紧急消息---");
    }
}

//特急消息模式
class ExtraUrgentMessageMode extends AbsMessageMode{

    public ExtraUrgentMessageMode(IMessageType messageType) {
        super(messageType);
    }

    @Override
    public void send(String user, String message) {
        super.send(user, message);
        System.out.println("---发送特急消息---");
    }
}