package com.cjt.desigmode.factory.factorymethod.calculator;

/**
 * 工厂方法-加减乘除运算
 * 写一个简单的计算器，满足加减乘除运算。逻辑比较简单：接受计算数据的输入，进行计算，返回结果。用Java实现。
 */
public class CalculatorMainFactoryMethod {

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

interface IOpertionFactoryMethod{

    //void setCalculator(ICalculator calculator);

    ICalculator createCalculator();

}

class OpertionAddFactoryMethod implements IOpertionFactoryMethod{

    @Override
    public ICalculator createCalculator() {
        return new CalculatorAdd();
    }
}

class OpertionSubFactoryMethod implements IOpertionFactoryMethod{

    @Override
    public ICalculator createCalculator() {
        return new CalculatorSub();
    }
}

class OpertionMulFactoryMethod implements IOpertionFactoryMethod{

    @Override
    public ICalculator createCalculator() {
        return new CalculatorMul();

    }
}

class OpertionDivFactoryMethod implements IOpertionFactoryMethod{

    @Override
    public ICalculator createCalculator() {
        return new CalculatorDiv();
    }
}


class Opertion{

    public void opertion(){

        IOpertionFactoryMethod factoryMethodAdd = new OpertionAddFactoryMethod();
        IOpertionFactoryMethod factoryMethodSub = new OpertionSubFactoryMethod();
        IOpertionFactoryMethod factoryMethodMul = new OpertionMulFactoryMethod();
        IOpertionFactoryMethod factoryMethodDiv = new OpertionDivFactoryMethod();

        int addNum = factoryMethodAdd.createCalculator().calculate(2,3);
        int subNum = factoryMethodSub.createCalculator().calculate(2,3);
        int mulNum = factoryMethodMul.createCalculator().calculate(2,3);
        int divNum = factoryMethodDiv.createCalculator().calculate(2,3);

        System.out.println("addNum=" + addNum + ", subNum=" + subNum + ", mulNum=" + mulNum + ", divNum="+divNum);

    }
}