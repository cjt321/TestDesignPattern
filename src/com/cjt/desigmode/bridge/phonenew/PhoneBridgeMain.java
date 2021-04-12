package com.cjt.desigmode.bridge.phonenew;

/**
 * 桥接模式。电话
 *
 * 场景：
 * 电话：vivo、华为
 * 电话类型：折叠（fold）、平面（plane）
 */
public class PhoneBridgeMain {

    public static void main(String[] args) {

        //使用vivo折叠式手机
        var vivoFold = new FoldPhoneType(new VivoPhone());
        vivoFold.open();
        vivoFold.call("张三");
        vivoFold.close();
        System.out.println("=======================================");

        //使用vivo平面式手机
        var vivoPlane =  new PlanePhoneType(new VivoPhone());
        vivoPlane.open();
        vivoPlane.call("alun");
        vivoPlane.close();
        System.out.println("=======================================");

        //使用华为折叠式手机
        var huaweiFold = new FoldPhoneType(new HuaweiPhone());
        huaweiFold.open();
        huaweiFold.call("李四");
        huaweiFold.close();
        System.out.println("=======================================");

        //使用小米平面式手机
        var xiaomiPlane = new PlanePhoneType(new XiaomiPhone());
        xiaomiPlane.open();
        xiaomiPlane.call("王五");
        xiaomiPlane.close();
        System.out.println("=======================================");

    }

}

//手机品牌
interface IPhoneBrand{
    void open();
    void close();
    void call(String user);
}

//vivo手机
class VivoPhone implements IPhoneBrand{

    @Override
    public void open() {
        System.out.println("打开vivo手机");
    }

    @Override
    public void close() {
        System.out.println("关闭vivo手机");
    }

    @Override
    public void call(String user) {
        System.out.println(user + "使用vivo打电话");
    }
}

//华为手机
class HuaweiPhone implements IPhoneBrand{

    @Override
    public void open() {
        System.out.println("打开华为手机");
    }

    @Override
    public void close() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void call(String user) {
        System.out.println(user + "使用华为手机打电话");
    }
}

class XiaomiPhone implements IPhoneBrand{

    @Override
    public void open() {
        System.out.println("打开小米手机");
    }

    @Override
    public void close() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void call(String user) {
        System.out.println(user + "使用小米手机打电话");
    }
}

//桥接抽象类，电话类型
abstract class AbsPhoneType{
    protected IPhoneBrand phoneBrand;

    public AbsPhoneType(IPhoneBrand phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public void open(){
        phoneBrand.open();
    }

    public void close(){
        phoneBrand.close();
    }

    public void call(String user){
        phoneBrand.call(user);
    }

}

//折叠手机
class FoldPhoneType extends AbsPhoneType{


    public FoldPhoneType(IPhoneBrand phoneBrand) {
        super(phoneBrand);
    }

    @Override
    public void open() {
        System.out.print("折叠式手机打开：");
        super.open();
    }

    @Override
    public void close() {
        System.out.print("折叠式手机关闭：");
        super.close();
    }

    @Override
    public void call(String user) {
        System.out.print("折叠式手机打电话：");
        super.call(user);
    }
}

//平面手机
class PlanePhoneType extends AbsPhoneType{

    public PlanePhoneType(IPhoneBrand phoneBrand) {
        super(phoneBrand);
    }

    @Override
    public void open() {
        System.out.print("平面式手机打开：");
        super.open();
    }

    @Override
    public void close() {
        System.out.print("平面式手机不关闭：");
        super.close();
    }

    @Override
    public void call(String user) {
        System.out.print("平面式手机打电话：");
        super.call(user);
    }
}