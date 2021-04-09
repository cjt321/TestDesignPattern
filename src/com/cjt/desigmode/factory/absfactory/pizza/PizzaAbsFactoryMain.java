package com.cjt.desigmode.factory.absfactory.pizza;

/**
 * 看一个披萨的项目：要便于披萨种类的扩展，要便于维护
 * 1) 披萨的种类很多(比如 GreekPizz、CheesePizz 等)
 * 2) 披萨的制作有 prepare，bake, cut, box
 * 3) 完成披萨店订购功能
 *
 * 抽象工厂
 */
public class PizzaAbsFactoryMain {

    public static void main(String[] args) {
        System.out.println("---抽象工厂---");
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

class BjGreekPizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("北京希腊pizza开始制作---");
    }
}

class BjCheesePizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("北京芝士pizza开始制作---");
    }
}

class GdGreekPizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("广东希腊pizza开始制作---");
    }
}

class GdCheesePizza extends BasePizza {

    @Override
    public void prepare() {
        System.out.println("广东芝士pizza开始制作---");
    }
}

interface IPizzaAbsFactory{
    BasePizza createPizza(String type);

    default void pizzaStep(BasePizza pizza){
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.bake();
        System.out.println("---pizza制作结束---");
    };
}

class BjAbsPizzaFactory implements IPizzaAbsFactory {


    @Override
    public BasePizza createPizza(String type) {
        BasePizza pizza = null;
        switch (type){
            case "cheese":
                pizza = new BjCheesePizza();
                break;
            case "greek":
                pizza = new BjGreekPizza();
                break;
        }
        if(pizza == null){
            System.out.println("--没有这种类型pizza---");
            return null;
        }
        pizzaStep(pizza);
        return pizza;
    }
}

class GdPizzaAbsFactory implements IPizzaAbsFactory{

    @Override
    public BasePizza createPizza(String type) {
        BasePizza pizza = null;
        switch (type){
            case "cheese":
                pizza = new GdCheesePizza();
                break;
            case "greek":
                pizza = new GdGreekPizza();
                break;
        }
        if(pizza == null){
            System.out.println("--没有这种类型pizza---");
            return null;
        }
        pizzaStep(pizza);
        return pizza;
    }
}

class OrderPizza{
    public void order(){
        IPizzaAbsFactory bjAbsPizzaFactory = new BjAbsPizzaFactory();
        IPizzaAbsFactory gdPizzaAbsFactory = new GdPizzaAbsFactory();

        System.out.println("---北京的pizza---");
        bjAbsPizzaFactory.createPizza("cheese");
        bjAbsPizzaFactory.createPizza("greek");

        System.out.println("\n\n");

        System.out.println("---广东的pizza---");
        gdPizzaAbsFactory.createPizza("cheese");
        gdPizzaAbsFactory.createPizza("greek");

    }
}