package com.cjt.designpattern.compositereuseprinciple.vechicle;

/**
 * 依赖方式。
 * 作为方法属性。
 */
public class B4 {

    public void xxx(A4 a4){
    }
    public void option1(A4 a4){
        a4.option1();
    }

    public void option2(A4 a4) {
        a4.option2();
    }

    public void option3(A4 a4) {
        a4.option3();
    }
}
