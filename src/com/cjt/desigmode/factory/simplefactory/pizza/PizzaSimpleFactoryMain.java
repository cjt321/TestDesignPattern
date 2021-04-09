package com.cjt.desigmode.factory.simplefactory.pizza;

/**
 * 看一个披萨的项目：要便于披萨种类的扩展，要便于维护
 * 1) 披萨的种类很多(比如 GreekPizz、CheesePizz 等)
 * 2) 披萨的制作有 prepare，bake, cut, box
 * 3) 完成披萨店订购功能
 *
 * 简单工厂
 */
public class PizzaSimpleFactoryMain {

    public static void main(String[] args) {
        System.out.println("---简单工厂---");
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

class GreekPizza extends BasePizza{

    @Override
    public void prepare() {
        System.out.println("希腊pizza开始制作---");
    }
}

class CheesePizza extends BasePizza{

    @Override
    public void prepare() {
        System.out.println("芝士pizza开始制作---");
    }
}

class OrderPizzaSimpleFactory{
    public BasePizza order(String type){
        BasePizza basePizza = null;
        switch (type){
            case "cheese":
                basePizza = new CheesePizza();
                break;
            case "greek":
                basePizza = new GreekPizza();
                break;
        }
        if (basePizza == null){
            System.out.println("pizza没有这种类型---");
            return null;
        }
        basePizza.prepare();
        basePizza.bake();
        basePizza.cut();
        basePizza.box();
        System.out.println("制作pizza结束---");
        return basePizza;
    }
}

class OrderPizza{
    public void order(){
        new OrderPizzaSimpleFactory().order("cheese");
        new OrderPizzaSimpleFactory().order("greek");
        new OrderPizzaSimpleFactory().order("xxx");
    }
}