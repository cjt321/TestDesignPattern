package com.cjt.designpattern.interfacesegregationprinciple.realize;

public class ClassC implements Interface1, Interface2{
    @Override
    public void option1() {
        System.out.println("ClassC option1");
    }

    @Override
    public void option2() {
        System.out.println("ClassC option2");
    }

    @Override
    public void option3() {
        System.out.println("ClassC option3");
    }

}
