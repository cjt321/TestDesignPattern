package com.cjt.desigmode.singleton;

/**
 * 饿汉式-静态代码块初始化
 */
public class SingletonHungry2 {

    private static SingletonHungry2 singletonHungry2;

    static {
        singletonHungry2 = new SingletonHungry2();
    }

    private SingletonHungry2(){
    }

    public static SingletonHungry2 getSingletonHungry2() {
        return singletonHungry2;
    }
}