package com.cjt.designpattern.dependenceinversionprinciple.vechicle;

public class PhoneMessage implements IMessage{
    @Override
    public void myMessage() {
        System.out.println("接收PhoneMessage");
    }
}
