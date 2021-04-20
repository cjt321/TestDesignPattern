package com.cjt.desigmode.proxy.staticproxy;

/**
 * 静态代理：代理类与被代理类必须实现同一接口，代理类依赖被代理类。
 *
 * 角色：
 * 被代理类：与代理类继承统一接口。
 * 代理类：与被代理类继承同一接口，聚合于被代理类。主要用来扩展被代理类。
 * 客户端：直接使用代理类。
 *
 * 例子：
 * userDao，用户根据id查询动作。
 * 被代理类：UserDao实现类，IUserDao实现接口。
 * 代理类：UserDaoProxy
 * 客户端：Client
 */
public class StaticProxyMain {

    public static void main(String[] args) {
        new Client().queryUser();
    }

}

//客户端
class Client{
    public void queryUser(){
        var userDaoProxy = new UserDaoProxy(new UserDao());
        userDaoProxy.getUser(1);
    }
}

//用户dao接口
interface IUserDao{
    String getUser(int id);
}

//用户dao实现。target对象，被代理类。
class UserDao implements IUserDao{

    @Override
    public String getUser(int id) {
        String name = "张三";
        System.out.println("查询用户结果：张三");
        return name;
    }
}

//代理类
class UserDaoProxy implements IUserDao{

    private IUserDao userDao;

    public UserDaoProxy(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public String getUser(int id) {
        System.out.println("用户dao代理类开始");
        var dao = userDao.getUser(id);
        System.out.println("用户dao代理类结束");
        return dao;
    }
}
