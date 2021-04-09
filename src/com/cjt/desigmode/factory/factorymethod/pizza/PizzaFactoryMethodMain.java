package com.cjt.desigmode.factory.factorymethod.pizza;

/**
 * 看一个披萨的项目：要便于披萨种类的扩展，要便于维护
 * 1) 披萨的种类很多(比如 GreekPizz、CheesePizz 等)
 * 2) 披萨的制作有 prepare，bake, cut, box
 * 3) 完成披萨店订购功能
 *
 * 工厂方法
 */
public class PizzaFactoryMethodMain {

    public static void main(String[] args) {
        System.out.println("---工厂方法---");
        new OrderPizza().order();
    }

}

abstract class BasePizza{
    //制作
    public abstract void prepare();

    //烤
    public void bake(){
        System.out.println("pizza开始烤了---");
    }

    //切
    public void cut(){
        System.out.println("pizza考试切了---");
    }

    public void box(){
        System.out.println("pizza打包完毕---");
    }

}

class GreekPizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("希腊pizza开始制作---");
    }
}

class CheesePizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("芝士pizza开始制作---");
    }
}

interface IPizzaFactoryMethod{
    BasePizza createPizza();
}

class GreekPizzaFactoryMethod implements IPizzaFactoryMethod{

    @Override
    public BasePizza createPizza() {
        BasePizza pizza = new GreekPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("制作pizza结束---");
        return pizza;
    }
}

class CheesePizzaFactoryMethod implements IPizzaFactoryMethod{

    @Override
    public BasePizza createPizza() {
        BasePizza pizza = new CheesePizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("制作pizza结束---");
        return pizza;
    }
}

class OrderPizza{
    public void order(){
        IPizzaFactoryMethod cheesePizza = new CheesePizzaFactoryMethod();
        IPizzaFactoryMethod greek = new GreekPizzaFactoryMethod();
        cheesePizza.createPizza();
        greek.createPizza();

    }
}