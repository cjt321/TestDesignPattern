package com.cjt.designpattern.liskovsubstitutionprincipl.realize;

public interface IOperation {

    default int add(int a, int b){return 0;}

    default int sub(int a, int b){return 0;}


}
