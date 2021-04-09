package com.cjt.desigmode.builder.factory;

/**
 * 用工厂模式实现：建造者模式。
 * 看看对比
 *
 * 1) 需要建房子：这一过程为打桩（piling）、砌墙（walls）、封顶（capping）
 * 2) 房子有各种各样的，比如普通房（common），高楼（highrise），别墅（villa），各种房子的过程虽然一样，但是要求不要相同的.
 */
public class FactoryMethodMain {

    public static void main(String[] args) {
        IHouseFactoryMethod commonHouseFactory = new CommonHouseFactoryMethod();
        IHouseFactoryMethod villaHouseFactory = new VillaHouseFactoryMethod();
        commonHouseFactory.build();
        villaHouseFactory.build();
    }

}

abstract class House{
    protected double base;
    protected double height;
    protected String name;

    //打桩
    public abstract void piling();
    //砌墙
    public abstract void walls();
    //封顶
    public abstract void capping();
}

class CommonHouse extends House{

    @Override
    public void piling() {
        System.out.println("普通房子 打桩");
    }

    @Override
    public void walls() {
        System.out.println("普通房子 砌墙");
    }

    @Override
    public void capping() {
        System.out.println("普通房子 封顶");
    }
}

class VillaHouse extends House{

    @Override
    public void piling() {
        System.out.println("别墅 打桩");
    }

    @Override
    public void walls() {
        System.out.println("别墅 砌墙");
    }

    @Override
    public void capping() {
        System.out.println("别墅 封顶");
    }
}

interface IHouseFactoryMethod{
    House build();
}

class CommonHouseFactoryMethod implements IHouseFactoryMethod{

    private CommonHouse house;

    @Override
    public House build() {
        house = new CommonHouse();
        house.piling();
        house.walls();
        house.capping();
        return house;
    }
}

class VillaHouseFactoryMethod implements IHouseFactoryMethod{

    private VillaHouse house;

    @Override
    public House build() {
        house = new VillaHouse();
        house.piling();
        house.walls();
        house.capping();
        return house;
    }
}