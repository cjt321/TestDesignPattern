package com.cjt.desigmode.prototype;


import java.io.*;

/**
 * 现在有一只羊 tom，姓名为: tom, 年龄为：1，颜色为：白色，请编写程序创建和 tom 羊 属性完全相同的 5 只羊。
 *
 * 原型模式：复制对象，不需要知道怎么复制，只需要用即可。
 *
 * clone：默认是浅拷贝的。使用clone是拷贝成员基础类型，至于引用类型直接使用。
 * clone深拷贝：要实现clone的深拷贝，需要把所有引用对象clone实现一次。因为基础类型是拷贝过去的，引用类型直接拷贝内存空间。
 * 使用序列化的深拷贝：实现序列化接口。通过ObjectOutputStream、ObjectInPutStream实现序列化与反序列化。
 */
public class PrototypeMain {

    public static void main(String[] args) {
        Sheep mySheep = new Sheep("tom", 1, "白色");
        mySheep.setMyFriend(new Sheep("marry", 1, "黄色"));


        Sheep cloneSheep1 = (Sheep) mySheep.deepClone();
        Sheep cloneSheep2 = (Sheep) mySheep.deepClone();
        Sheep cloneSheep3 = (Sheep) mySheep.deepClone();
        Sheep cloneSheep4 = (Sheep) mySheep.deepClone();
        Sheep cloneSheep5 = (Sheep) mySheep.deepClone();

        System.out.println("mySheep:" + mySheep + ", hashcode=" + mySheep.hashCode() + ", friend.hashcode=" + mySheep.getMyFriend().hashCode());
        System.out.println("cloneSheep1:" + cloneSheep1 + ", hashcode=" + cloneSheep1.hashCode() + ", friend.hashcode=" + cloneSheep1.getMyFriend().hashCode());
        System.out.println("cloneSheep2:" + cloneSheep2 + ", hashcode=" + cloneSheep2.hashCode() + ", friend.hashcode=" + cloneSheep2.getMyFriend().hashCode());
        System.out.println("cloneSheep3:" + cloneSheep3 + ", hashcode=" + cloneSheep3.hashCode() + ", friend.hashcode=" + cloneSheep3.getMyFriend().hashCode());
        System.out.println("cloneSheep4:" + cloneSheep4 + ", hashcode=" + cloneSheep4.hashCode() + ", friend.hashcode=" + cloneSheep4.getMyFriend().hashCode());
        System.out.println("cloneSheep5:" + cloneSheep5 + ", hashcode=" + cloneSheep5.hashCode() + ", friend.hashcode=" + cloneSheep5.getMyFriend().hashCode());

    }

}

class Sheep implements Serializable {
    private String name;
    private int age;
    private String color;
    private Sheep myFriend;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep cloneSheep = (Sheep) super.clone();
        if(this.myFriend != null){
            cloneSheep.myFriend = (Sheep) this.myFriend.clone();
        }
        return cloneSheep;
    }*/

    public Object deepClone(){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Sheep cloneSheep = (Sheep) objectInputStream.readObject();
            return cloneSheep;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", myFriend=" + myFriend +
                '}';
    }

    public Sheep getMyFriend() {
        return myFriend;
    }

    public void setMyFriend(Sheep myFriend) {
        this.myFriend = myFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

