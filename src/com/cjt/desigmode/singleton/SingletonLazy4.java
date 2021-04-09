package com.cjt.desigmode.singleton;

/**
 * 懒汉式-双重判断
 */
public class SingletonLazy4 {

    private static SingletonLazy4 singletonLazy4;

    private SingletonLazy4(){}

    public static SingletonLazy4 getSingletonLazy4(){
        if(singletonLazy4 == null){
            synchronized (SingletonLazy4.class){
                if(singletonLazy4 == null)
                    singletonLazy4 = new SingletonLazy4();
            }
        }
        return singletonLazy4;
    }

}
