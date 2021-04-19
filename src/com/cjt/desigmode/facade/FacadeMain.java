package com.cjt.desigmode.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * 外观模式。
 * 客户端调用子系统复杂，则可以使用外观模式。
 * 实现方式：中间加接口层，封装子系统的行为。客户端只依赖于中间层。
 *
 * 例子：当你通过电话给商店下达订单时， 接线员就是该商店的所有服务和部门的外观。
 * 接线员为你提供了一个同购物系统、 支付网关和各种送货服务进行互动的简单语音接口。
 *
 * 子系统：购物下单ShoppingSys、支付网关PaymentSys、送货服务DeliverSys
 * 客户端Client：顾客下单
 * 外观类：接线员TelephoneOperator （called、calling、endCall）
 *
 *
 */
public class FacadeMain {

    public static void main(String[] args) {
        new Client().order();
    }
}

//客户端，顾客
class Client{
    public void order(){
        //下单
        var t =  new TelephoneOperatorFacade("1001");
        t.called("张三");
        t.calling("下单");
        t.endCall();

    }
}

//外观者，电话接待员
class TelephoneOperatorFacade{

    private String name;

    public TelephoneOperatorFacade(String name){
        this.name = name;
    }

    //开始接电话
    public void called(String clientUsername){
        System.out.println("---接待员" + name + ", 开始接电话，顾客是"+clientUsername+"---");
    }

    //正在接电话
    public void calling(String order){
        //下单
        ShoppingSys shoppingSys = new ShoppingSys();
        List<String> commodities = new ArrayList<>();
        commodities.add("球鞋");
        commodities.add("手机套");
        shoppingSys.choose(commodities);
        shoppingSys.order();
        //支付
        PaymentSys paymentSys = new PaymentSys();
        paymentSys.pay(100);
        paymentSys.successful();
        //送货
        DeliverSys deliverSys = new DeliverSys();
        deliverSys.packing();
        deliverSys.deawOut();
        deliverSys.visit();
    }

    //结束接电话
    public void endCall(){
        System.out.println("---接待员" + name + ", 结束接电话---");
    }
}

//购物下单
class ShoppingSys{

    private List<String> commodities;

    public void choose(List<String> commodities){
        this.commodities = commodities;
        System.out.print("选择了商品：");
        commodities.forEach(o-> System.out.print(o + "  "));
        System.out.println();
    }

    public List<String> order(){
        System.out.print("开始下单：");
        commodities.forEach(o-> System.out.print(o + "  "));
        System.out.println();
        return commodities;
    }
}

//支付网关
class PaymentSys{
    public void pay(double price){
        System.out.println("开始支付，价格为：" + price);
    }

    public void successful(){
        System.out.println("支付成功");
    }

    public void failed(){
        System.out.println("支付失败");
    }
}

//送货服务
class DeliverSys{

    //打包
    public void packing(){
        System.out.println("打包货品...");
    }

    //外出送货
    public void deawOut(){
        System.out.println("外出送货...");
    }

    //送货上门
    public void visit(){
        System.out.println("送货上门，完毕！");
    }
}