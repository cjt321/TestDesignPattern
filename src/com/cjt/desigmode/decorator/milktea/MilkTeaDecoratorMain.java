package com.cjt.desigmode.decorator.milktea;

/**
 * 装饰者模式。
 *
 * 装饰者：调料
 * 被装饰者：奶茶
 *
 *
 * 例子：
 * 奶茶（MilkTea）：珍珠奶茶（PearlMilkTea）、奶盖奶茶（CoverMilkTea）、白奶茶（WhiteMilkTea）
 * 调料（FlavourDecorator）：加冰（IcedAdd）、加热（HotAdd）、加糖（SugarAdd）、加大（BigAdd）
 *
 */
public class MilkTeaDecoratorMain {

    public static void main(String[] args) {
        //下单买奶茶
        new MilkTeaClient().order();
    }

}

//客户端
class MilkTeaClient{

    public void order(){
        //下一杯奶盖奶茶+加大+加糖+加冰
        IMilkTea coverMilkTea = new CoverMilkTea();
        System.out.println("奶盖:" + coverMilkTea.cost());

        coverMilkTea = new BigAdd(coverMilkTea);
        System.out.println("奶盖+加大:" + coverMilkTea.cost());

        coverMilkTea = new SugarAdd(coverMilkTea);
        System.out.println("奶盖+加大+加糖:" + coverMilkTea.cost());

        coverMilkTea = new IcedAdd(coverMilkTea);
        System.out.println("奶盖+加大+加糖+加冰:" + coverMilkTea.cost());
    }
}

//奶茶接口，被装饰者
interface IMilkTea{

    float cost();

    void setPrice(float price);
    float getPrice();

    void setName(String name);
    String getName();

}

//奶茶抽象类，被装饰者
abstract class AbsMilkTea implements IMilkTea{

    protected float price;
    protected String name;

    @Override
    public float cost() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbsMilkTea{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

//珍珠奶茶
class PearlMilkTea extends AbsMilkTea{

    public PearlMilkTea(){
        setName("珍珠奶茶");
        setPrice(12f);
    }
}

//奶盖奶茶
class CoverMilkTea extends AbsMilkTea{

    public CoverMilkTea(){
        setName("奶盖奶茶");
        setPrice(18f);
    }
}

//白奶茶
class WhiteMilkTea extends AbsMilkTea{
    public WhiteMilkTea(){
        setName("白奶茶");
        setPrice(8f);
    }
}

//调料-装饰者
abstract class AbsFlavourDecorator implements IMilkTea{
    protected IMilkTea milkTea;
    protected float price;
    protected String name;

    public AbsFlavourDecorator(IMilkTea milkTea){
        this.milkTea = milkTea;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float cost() {
        //这里注意：装饰者计算时，要加上被装饰者的计算结果。
        return price + milkTea.cost();
    }

    @Override
    public String toString() {
        return "AbsFlavourDecorator{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

//加冰
class IcedAdd extends AbsFlavourDecorator{

    public IcedAdd(IMilkTea milkTea) {
        super(milkTea);
        setName("加冰");
        setPrice(0.9f);
    }

}

//加热
class HotAdd extends AbsFlavourDecorator{

    public HotAdd(IMilkTea milkTea) {
        super(milkTea);
        setName("加热");
        setPrice(0.2f);
    }
}

//加糖
class SugarAdd extends AbsFlavourDecorator{

    public SugarAdd(IMilkTea milkTea) {
        super(milkTea);
        setName("加糖");
        setPrice(1.2f);
    }
}

//加大
class BigAdd extends AbsFlavourDecorator{

    public BigAdd(IMilkTea milkTea) {
        super(milkTea);
        setName("加大");
        setPrice(3.5f);
    }
}


