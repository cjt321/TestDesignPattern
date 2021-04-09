package com.cjt.designpattern.compositereuseprinciple.vechicle;

/**
 * 依赖：组合方式。
 * A2作为B2的必要部分。作为成员变量，并且初始化的时候赋值。
 */
public class B2{

    private A2 a2;

    public B2(A2 a2){
        this.a2 = a2;
    }

    public void option1(){
        a2.option1();
    }

    public void option2(){
        a2.option2();
    }

    public void option3(){
        a2.option3();
    }

}
