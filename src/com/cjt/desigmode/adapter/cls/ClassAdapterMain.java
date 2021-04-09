package com.cjt.desigmode.adapter.cls;

/**
 * 适配器模式-类适配器模式
 * 类适配器、对象适配器，2种实现方式。
 *
 * 类适配器：适配器继承被适配类。
 * 优点：可以重写被适配类方法，改装被适配类。
 * 缺点：一是适配器与被适配类增加了耦合度，因为是继承。二是适配器继承了被适配类，所以适配器对外提供了被适配类的方法。
 *
 * 以生活中充电器的例子来讲解适配器，充电器本身相当于 Adapter，220V 交流电相当于 src (即被适配者)，我们
 * 的目 dst(即 目标)是 5V 直流电
 *
 * 此类是类适配器
 */
class ClassAdapterMain {

    public static void main(String[] args) {
        new PhoneClient().charge(new Voltage5V());
    }

}

//被适配类
class Voltage220V{

    public void output(){
        System.out.println("220V的电压输出");
    }
}

//适配器
interface IVoltageAdapter{
    void voltage5v();
}

//适配类
class Voltage5V extends Voltage220V implements IVoltageAdapter {


    @Override
    public void voltage5v() {
        output();
        System.out.println("转换电压开始");
        System.out.println("转换成5v电压");
        System.out.println("转换电压结束");
    }
}

class PhoneClient{

    public void charge(IVoltageAdapter voltageAdapter){
        System.out.println("开始充电");
        voltageAdapter.voltage5v();
        System.out.println("结束充电");
    }

}
