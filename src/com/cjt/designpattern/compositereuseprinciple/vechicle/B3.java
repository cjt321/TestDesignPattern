package com.cjt.designpattern.compositereuseprinciple.vechicle;

/**
 * 依赖：聚合方式。
 * B3依赖A3，但A3不是B3的必要部分
 */
public class B3 {

    private A3 a3;

    public void setA3(A3 a3){
        this.a3 = a3;
    }
    public void option1(){
        a3.option1();
    }

    public void option2(){
        a3.option2();
    }

    public void option3(){
        a3.option3();
    }

}
