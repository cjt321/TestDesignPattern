package com.cjt.desigmode.singleton;

/**
 *懒汉式-同步代码块
 */
public class SingletonLazy3 {

    private static SingletonLazy3 singletonLazy1;

    private SingletonLazy3(){}

    public static synchronized SingletonLazy3 getSingletonLazy1() {
        if (singletonLazy1 == null){
            singletonLazy1 = new SingletonLazy3();
        }
        return singletonLazy1;
    }
}
