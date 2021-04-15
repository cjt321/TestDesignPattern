package com.cjt.desigmode.decorator.message;

/**
 * 装饰者模式。
 *
 * 例子：发送qq、wechat、sms消息。
 * 被装饰者：message
 * 装饰者：qq、wechat、sms
 *
 * 备注：这里装饰者模式不是很适用这种消息场景，可以使用组合模式。
 */
public class MessageDecoratorMain {

    public static void main(String[] args) {
        new Client().send();
    }

}

//客户端类
class Client {
    public void send(){
        IMessage message = new MessageSend("hello", "陈六");
        message = new Qq(message);
        message = new Wechat(message);
        message = new Sms(message);

        message.sendMessage();
    }
}

//message接口
interface IMessage{
    void sendMessage();
}

//发送消息
class MessageSend implements IMessage{

    private String message;
    private String user;
    public MessageSend(String message, String user){
        this.message = message;
        this.user = user;
    }

    @Override
    public void sendMessage() {
        System.out.println("向" + user + "发送消息：" + message);
    }
}

//装饰者抽象类
abstract class AbsMessageDecorator implements IMessage{

    private IMessage message;

    public AbsMessageDecorator(IMessage message){
        this.message = message;
    }

    @Override
    public void sendMessage() {
        message.sendMessage();
    }
}

//qq
class Qq extends AbsMessageDecorator{

    public Qq(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage() {
        System.out.print("发送qq消息：");
        super.sendMessage();
    }
}

//wechat
class Wechat extends AbsMessageDecorator{

    public Wechat(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage() {
        System.out.print("发送wechat消息：");
        super.sendMessage();
    }
}

//sms
class Sms extends AbsMessageDecorator{

    public Sms(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage() {
        System.out.print("发送sms消息：");
        super.sendMessage();
    }
}