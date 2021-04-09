package com.cjt.designpattern.dependenceinversionprinciple.vechicle;

public class Person {

    public void receive(IMessage message){
        message.myMessage();
    }

}
