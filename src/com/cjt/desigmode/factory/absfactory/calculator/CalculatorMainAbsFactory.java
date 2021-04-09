package com.cjt.desigmode.factory.absfactory.calculator;


/**
 * 抽象工厂方式-加减乘除运算
 * 写一个简单的计算器，满足加减乘除运算。逻辑比较简单：接受计算数据的输入，进行计算，返回结果。用Java实现。
 */
public class CalculatorMainAbsFactory {

    public static void main(String[] args) {

        new Opertion().opertion();

    }

}

interface ICalculator{

    int calculate (int a, int b);


}

class CalculatorAdd implements ICalculator {

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }

}

class CalculatorSub implements ICalculator {

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }

}

class CalculatorMul implements ICalculator {

    @Override
    public int calculate(int a, int b) {
        return a*b;
    }

}

class CalculatorDiv implements ICalculator {

    @Override
    public int calculate(int a, int b) {
        return a/b;
    }

}

interface IOpertionAbsFactory{

    ICalculator createCalculator(String op);

}

class AddSubOpertionAbsFactory implements IOpertionAbsFactory {


    @Override
    public ICalculator createCalculator(String op) {
        switch (op){
            case "+":
                return new CalculatorAdd();
            case "-":
                return new CalculatorSub();
        }
        return null;
    }
}

class MulDivOpertionAbsFactory implements IOpertionAbsFactory {


    @Override
    public ICalculator createCalculator(String op) {
        switch (op){
            case "*":
                return new CalculatorMul();
            case "/":
                return new CalculatorDiv();
        }
        return null;
    }
}


class Opertion{

    public void opertion(){

        IOpertionAbsFactory addSubOpertionAbsFactory = new AddSubOpertionAbsFactory();
        IOpertionAbsFactory mulDivOpertionAbsFactory = new MulDivOpertionAbsFactory();

        int addNum = addSubOpertionAbsFactory.createCalculator("+").calculate(1,2);
        int subNum = addSubOpertionAbsFactory.createCalculator("-").calculate(1,2);
        int mulNum = mulDivOpertionAbsFactory.createCalculator("*").calculate(1,2);
        int divNum = mulDivOpertionAbsFactory.createCalculator("/").calculate(1,2);

        System.out.println("addNum=" + addNum + ", subNum=" + subNum + ", mulNum=" + mulNum + ", divNum="+divNum);

    }
}