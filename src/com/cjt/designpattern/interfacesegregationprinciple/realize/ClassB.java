package com.cjt.designpattern.interfacesegregationprinciple.realize;

public class ClassB {

    public void methodOption1(Interface1 interface1){
        interface1.option1();
    }

    public void methodOption4(Interface3 interface3){
        interface3.option4();
    }

    public void methodOption5(Interface3 interface3){
        interface3.option5();
    }

}
