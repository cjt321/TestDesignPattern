package com.cjt.designpattern.dependenceinversionprinciple;

import com.cjt.designpattern.dependenceinversionprinciple.vechicle.EmailMessage;
import com.cjt.designpattern.dependenceinversionprinciple.vechicle.Person;
import com.cjt.designpattern.dependenceinversionprinciple.vechicle.PhoneMessage;

/**
 * 依赖倒置原则
 */
public class DependenceInversionPrincipleMain {

    public static void main(String[] args) {
        var person = new Person();
        person.receive(new EmailMessage());
        person.receive(new PhoneMessage());
    }

}
