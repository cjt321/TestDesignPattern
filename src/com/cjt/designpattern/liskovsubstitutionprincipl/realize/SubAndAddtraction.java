package com.cjt.designpattern.liskovsubstitutionprincipl.realize;

public class SubAndAddtraction extends Additioin {

    private Additioin additioin;

    public SubAndAddtraction(){
        additioin = new Additioin();
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int add(int a, int b) {
        return additioin.add(a, b);
    }
}
