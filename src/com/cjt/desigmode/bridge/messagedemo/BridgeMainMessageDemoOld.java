package com.cjt.desigmode.bridge.messagedemo;

/**
 * 没用桥接模式实现。
 * 只能继承
 */
public class BridgeMainMessageDemoOld {

    public static void main(String[] args){
        System.out.println("---BridgeMainMessageDemoOld---");
        new PhoneCommonMessage().send("alun", "马上联系我");
        new PhoneUrgencyMessage().send("alun", "没听到吗？马上联系我！");
        new EmailCommonMessage().send("洪兴", "关于龙头棍的消息");
        new EmailUrgencyMessage().send("东星", "龙头棍出来了！");
    }

}

//消息接口
interface IMessage{
    void send(String user, String message);
}

//普通消息
class CommonMessage implements IMessage{

    @Override
    public void send(String user, String message) {
        System.out.println(user + "发送普通消息：" + message);
    }
}

//手机消息
class PhoneCommonMessage extends CommonMessage{
    @Override
    public void send(String user, String message) {
        System.out.println("用手机：");
        super.send(user, message);
    }
}

//email消息
class EmailCommonMessage extends CommonMessage{
    @Override
    public void send(String user, String message) {
        System.out.println("用email：");
        super.send(user, message);
    }
}

//紧急消息
class UrgencyMessage implements IMessage{

    @Override
    public void send(String user, String message) {
        System.out.println(user + "发送紧急消息：" + message);
    }
}

//电话紧急消息
class PhoneUrgencyMessage extends UrgencyMessage{
    @Override
    public void send(String user, String message) {
        System.out.println("用手机：");
        super.send(user, message);
    }
}

//email紧急消息
class EmailUrgencyMessage extends UrgencyMessage{
    @Override
    public void send(String user, String message) {
        System.out.println("用手机：");
        super.send(user, message);
    }
}