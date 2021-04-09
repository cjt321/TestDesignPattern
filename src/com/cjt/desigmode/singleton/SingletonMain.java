package com.cjt.desigmode.singleton;

public class SingletonMain {

    public static void main(String[] args) {

        //单例模式1：饿汉式-静态常量
        SingletonHungry1 singletonHungry1 = SingletonHungry1.getSingletonHungry1();
        System.out.println("singletonHungry1=" + singletonHungry1);

        //单例模式2：饿汉式-静态代码块
        SingletonHungry2 singletonHungry2 = SingletonHungry2.getSingletonHungry2();
        System.out.println("singletonHungry2=" + singletonHungry2);

        //单例模式3：懒汉式-同步代码块
        SingletonLazy3 singletonLazy3 = SingletonLazy3.getSingletonLazy1();
        System.out.println("singletonLazy3=" + singletonLazy3);

        //单例模式4：双重判断
        SingletonLazy4 singletonLazy4 = SingletonLazy4.getSingletonLazy4();
        System.out.println("singletonLazy4=" + singletonLazy4);

        //单例模式5：静态内部类
        SingletonLazy5 singletonLazy5 = SingletonLazy5.getSingletonLazy5();
        System.out.println("singletonLazy5=" + singletonLazy5);

        //单例模式6：枚举
        SingletonEnum6 singletonEnum6 = SingletonEnum6.INSTANCE;
        System.out.println("singletonEnum6=" + singletonEnum6);

    }

}
