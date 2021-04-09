package com.cjt.designpattern.compositereuseprinciple;

import com.cjt.designpattern.compositereuseprinciple.vechicle.*;

/**
 * 合成复用原则。
 * 原则是尽量使用合成/聚合的方式，而不是使用继承
 */
public class CompositeReusePrincipleMain {

    public static void main(String[] args) {

        //继承方式，不符合合成原则
        B1 b1 = new B1();
        b1.option1();

        //强依赖关系（组合，A2是B2的组成部分，不能缺少）。符合合成复用原则
        B2 b2 = new B2(new A2());
        b2.option1();

        //依赖关系（聚合，A3是B3的组成部分，可以缺少B3）。符合合成复用原则。
        B3 b3 = new B3();
        b3.setA3(new A3());
        b3.option1();

        //弱依赖关系。符合合成复用原则。
        B4 b4 = new B4();
        b4.option1(new A4());

    }

}
