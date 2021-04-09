package com.cjt.designpattern.liskovsubstitutionprincipl;

import com.cjt.designpattern.liskovsubstitutionprincipl.realize.Additioin;
import com.cjt.designpattern.liskovsubstitutionprincipl.realize.SubAndAddtraction;

/**
 * 里氏替换原则
 * 1.继承会增加类与类的耦合度，侵入到类。所以尽量使用依赖、聚合、组合替代继承
 * 2.继承时，尽量不重写父类方法
 */
public class LiskovSubstitutionPrinciplMain {

    public static void main(String[] args) {
        var addition = new Additioin();
        var addnum = addition.add(1,2);
        System.out.println("addnum:" + addnum);

        var subtraction = new SubAndAddtraction();
        var subnum = subtraction.sub(1,2);
        var addnum2 = subtraction.add(1,2);
        System.out.println("subnum:" + subnum + " addnum2:"+ addnum2);

    }

}
