package com.cjt.desigmode.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理。方式一：反射方式
 *
 * 角色：
 * 被代理：被代理实现类、被代理接口。
 * 代理工厂：通过方式方式创建代理，并且使用代理中的方法。在代码中不依赖代码
 *
 * 例子：
 * userDao，用户根据id查询动作。
 * 被代理类：UserDao实现类，IUserDao实现接口。
 * 代理工厂类：UserProxyFactory
 * 客户端：Client
 *
 */
public class DynamicProxyMain {

    public static void main(String[] args) {
        new Client().queryUser();
    }
}

//客户端
class Client{
    public void queryUser(){
        UserDao userDao = new UserDao();
        var proxyFactory = new UserProxyFactory(userDao);
        var userDaoProxy = (IUserDao)proxyFactory.getProxyInstance();
        userDaoProxy.getUser(1);

        System.out.println("userDao=" + userDao.hashCode());
        System.out.println("userDaoProxy=" + userDaoProxy.hashCode());
    }
}

//被代理IUserDao，接口interface
interface IUserDao{
    String getUser(int id);
}

//被代理实现类。
class UserDao implements IUserDao{

    @Override
    public String getUser(int id) {
        String name = "李四";
        System.out.println("获取用户：李四");
        return name;
    }
}

//代理工厂
class UserProxyFactory{
    private Object target;

    public UserProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理开始");
                var r = method.invoke(target, args);
                System.out.println("动态代理结束");
                //System.out.println("object=" + proxy);
                return r;
            }
        });
    }
}