package com.cjt.desigmode.prototype.springbeantest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 原型模式，源码分析与测试。spring-bean
 */
public class SourceCodeJavaBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/cjt/desigmode/prototype/springbeantest/beans.xml");
        PrototypeEntity bean = (PrototypeEntity)context.getBean("prototypeEntity");
        bean.setId("100");
        bean.setFriend(new PrototypeEntity());
        System.out.println("bean=" + bean + ", hashcode=" + bean.hashCode() + ", friend=" + bean.getFriend());

        PrototypeEntity bean2 = (PrototypeEntity) context.getBean("prototypeEntity");
        System.out.println("bean2=" + bean2 + ", hashcode=" + bean2.hashCode() + ", friend=" + bean2.getFriend());

    }

}
