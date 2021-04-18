package com.cjt.desigmode.flyweight;

/**
 * 享元模式
 *
 * 角色：
 *  享元工厂：提供客户端使用，获取与整合享元产品对象集合。
 *  享元抽象类：内部状态与外部状态类。即可变状态与不可变状态。
 *  产品类：不能共享的部分。即在享元模式中的内部状态。
 *
 * 例子：
 * 小型的外包项目，给客户 A 做一个产品展示网站，客户 A 的朋友感觉效果不错，也希望做这样的产品展示网站，但是要求都有些不同：
 * 1) 有客户要求以新闻的形式发布
 * 2) 有客户人要求以博客的形式发布
 * 3) 有客户希望以微信公众号的形式发布
 *
 * 分析：
 * 享元抽象角色：AbsProjectFlyweight
 * 享元工厂角色：ProjectFactory
 * 产品类，不可变类：外部状态。ProjecContentConcreteFlyweight。网站的内部内容不可变。
 * 产品类，可变类：内部状态。 UserUnsharedConcreteFlyweight。网站的用户。
 *
 */
public class FlyweightMain {

    public static void main(String[] args) {

    }

}
