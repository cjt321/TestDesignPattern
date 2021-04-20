package com.cjt.desigmode.proxy.dynamicproxcglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理，方式二：cglib
 *
 * 例子：
 * userDao，用户根据id查询动作。
 * 被代理类：UserDao实现类。
 * 代理工厂类：UserProxyCglibFactory
 * 客户端：Client
 */
public class DynamicProxyCglibMain {

    public static void main(String[] args) {
        new Client().queryUser();
    }

}

//客户端
class Client{
    public void queryUser(){
        UserDao userDao = new UserDao();
        UserProxyCglibFactory proxyCglibFactory = new UserProxyCglibFactory(userDao);
        UserDao proxyUserDao = (UserDao) proxyCglibFactory.getInstance();
        proxyUserDao.getUser(1);
    }
}

//被代理类，具体类。
class UserDao{
    public String getUser(int id){
        String name = "王五";
        System.out.println("获取用户信息：" + name);
        return name;
    }
}

//动态代理类
class UserProxyCglibFactory implements MethodInterceptor {

    private Object target;

    public UserProxyCglibFactory(Object target){
        this.target = target;
    }

    public Object getInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启cglib动态代理");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("结束cglib动态代理");
        return result;
    }

}
