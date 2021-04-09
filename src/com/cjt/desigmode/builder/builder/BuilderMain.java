package com.cjt.desigmode.builder.builder;

/**
 * 建造者模式。
 *
 * 1) 需要建房子：这一过程为打桩（piling）、砌墙（walls）、封顶（capping）
 * 2) 房子有各种各样的，比如普通房（common），高楼（highrise），别墅（villa），各种房子的过程虽然一样，但是要求不要相同的.
 */
public class BuilderMain {

    public static void main(String[] args) {
        var houseDirector = new HouseDirector();
        houseDirector.builderHouse(new CommonHouseBuilder());
        houseDirector.builderHouse(new VillaHouseBuilder());
    }

}

//产品
class House{
    protected double base;
    protected double height;
    protected String name;
}

//房子建造者
abstract class AbsHouseBuilder{
    protected House house = null;

    //打桩
    abstract void piling();

    //砌墙
    abstract void walls();

    //封顶
    abstract void capping();

    //build
    public House build(){
        return house;
    }

}

//普通房子建造者
class CommonHouseBuilder extends AbsHouseBuilder {

    private House house;
    public CommonHouseBuilder(){
        house = new House();
    }

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
        System.out.println("普通房子 打桩");
    }

}

//别墅建造者
class VillaHouseBuilder extends AbsHouseBuilder {

    private House house;
    public VillaHouseBuilder(){
        house = new House();
    }

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
        System.out.println("别墅 打桩");
    }
}

//指挥者
class HouseDirector {

    public House builderHouse(AbsHouseBuilder houseBuilder){
        houseBuilder.piling();
        houseBuilder.walls();
        houseBuilder.capping();
        return houseBuilder.build();
    }
}