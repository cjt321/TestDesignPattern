package com.cjt.desigmode.factory.simplefactory.calculator;

/**
 * 简单工厂-加减乘除运算
 * 写一个简单的计算器，满足加减乘除运算。逻辑比较简单：接受计算数据的输入，进行计算，返回结果。用Java实现。
 */
public class CalculatorMainSimpleFactory {

    public static void main(String[] args) {

        new Opertion().opertion();

    }

}

interface ICalculator{

    int calculate (int a, int b);

}

class CalculatorAdd implements ICalculator{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}

class CalculatorSub implements ICalculator{

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}

class CalculatorMul implements ICalculator{

    @Override
    public int calculate(int a, int b) {
        return a*b;
    }
}

class CalculatorDiv implements ICalculator{

    @Override
    public int calculate(int a, int b) {
        return a/b;
    }
}

class OpertionSimpleFactory{

    public static ICalculator calculator(String option){
        ICalculator calculator = null;
        switch (option){
            case "add":
                calculator = new CalculatorAdd();
                break;
            case "sub":
                calculator = new CalculatorSub();
                break;
            case "mul":
                calculator = new CalculatorMul();
                break;
            case "div":
                calculator = new CalculatorDiv();
                break;

        }
        return calculator;
    }


}

class Opertion{

    public void opertion(){

        ICalculator calculatorAdd = OpertionSimpleFactory.calculator("add");
        ICalculator calculatorSub = OpertionSimpleFactory.calculator("sub");
        ICalculator calculatorMul = OpertionSimpleFactory.calculator("mul");
        ICalculator calculatorDiv = OpertionSimpleFactory.calculator("div");

        int addNum = calculatorAdd.calculate(2, 3);
        int subNum = calculatorSub.calculate(2, 3);
        int mulNum = calculatorMul.calculate(2, 3);
        int divNum = calculatorDiv.calculate(2, 3);

        System.out.println("addNum=" + addNum + ", subNum=" + subNum + ", mulNum=" + mulNum + ", divNum="+divNum);

    }
}