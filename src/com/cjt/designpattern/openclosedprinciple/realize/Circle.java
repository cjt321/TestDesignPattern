package com.cjt.designpattern.openclosedprinciple.realize;

public class Circle implements IShape{
    @Override
    public void printShape() {
        System.out.println("画圆形");
    }
}
