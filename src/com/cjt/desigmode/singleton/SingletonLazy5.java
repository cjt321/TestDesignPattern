package com.cjt.desigmode.singleton;

/**
 * 懒汉式-私有静态内部类
 */
public class SingletonLazy5 {

    private SingletonLazy5(){}

    private static class SingletonLazy5Static{
        public final static SingletonLazy5 singletonLazy5 = new SingletonLazy5();
    }

    public static SingletonLazy5 getSingletonLazy5() {
        return SingletonLazy5Static.singletonLazy5;
    }
}
