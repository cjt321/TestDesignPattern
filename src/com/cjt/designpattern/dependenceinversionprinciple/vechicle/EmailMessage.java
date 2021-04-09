package com.cjt.designpattern.dependenceinversionprinciple.vechicle;

public class EmailMessage implements IMessage {


    @Override
    public void myMessage() {
        System.out.println("接收EmailMessage");
    }
}
