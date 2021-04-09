package com.cjt.designpattern.interfacesegregationprinciple.realize;

public class ClassD implements Interface1, Interface3{
    @Override
    public void option1() {
        System.out.println("ClassD option1");
    }

    @Override
    public void option4() {
        System.out.println("ClassD option4");
    }

    @Override
    public void option5() {
        System.out.println("ClassD option5");
    }
}
