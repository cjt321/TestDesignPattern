package com.cjt.designpattern.liskovsubstitutionprincipl.realize;

public class Additioin implements IOperation {

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
