package com.cjt.designpattern.interfacesegregationprinciple;

import com.cjt.designpattern.interfacesegregationprinciple.realize.*;

/**
 * 接口隔离原则
 */
public class InterfaceSegregationPrincipleMain {

    public static void main(String[] args) {
        var classA = new ClassA();
        var classB = new ClassB();

        classA.methodOption1(new ClassC());
        classA.methodOption2(new ClassC());
        classA.methodOption3(new ClassC());

        classB.methodOption1(new ClassD());
        classB.methodOption4(new ClassD());
        classB.methodOption5(new ClassD());
    }

}
