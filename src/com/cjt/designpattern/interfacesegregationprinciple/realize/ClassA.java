package com.cjt.designpattern.interfacesegregationprinciple.realize;

public class ClassA {

    public void methodOption1(Interface1 interface1){
        interface1.option1();
    }

    public void methodOption2(Interface2 interface2){
        interface2.option2();
    }

    public void methodOption3(Interface2 interface2){
        interface2.option3();
    }

}
