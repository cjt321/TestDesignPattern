package com.cjt.desigmode.singleton;

/**
 * 饿汉式-静态常量初始化
 */
public class SingletonHungry1 {

    private final static SingletonHungry1 singletonHungry1 = new SingletonHungry1();

    private SingletonHungry1(){
    }

    public static SingletonHungry1 getSingletonHungry1() {
        return singletonHungry1;
    }
}
