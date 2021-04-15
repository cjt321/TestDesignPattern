package com.cjt.desigmode.composite.soldier;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

/**
 * 桥接设置模式。
 * 可以用树型表示的，并且他们之间的特征相似，可以使用组合模式。
 * 桥接模式的几个角色：容器、接口（抽象类）树，树叶。
 *
 *
 * 例子：军(Army)->旅(Force)->团(Roll)->军人(Soldier)
 */
public class SoldierCompositeMain {

    public static void main(String[] args) {
        var army1 = new Army("第一军队");
        var force1 = new Force("第一旅");
        var force2 = new Force("第二旅");
        var force3 = new Force("第三旅");
        army1.add(force1);
        army1.add(force2);
        army1.add(force3);

        var roll1 = new Roll("第一团");
        var roll2 = new Roll("第二团");
        force1.add(roll1);
        force1.add(roll2);

        var soldier1 = new Soldier("张三");
        var soldier2 = new Soldier("李四");
        roll1.add(soldier1);
        roll1.add(soldier2);

        army1.print();
    }

}

//军队组合抽象类。
abstract class TroopsComposite {

    protected abstract void add(TroopsComposite troopsComposite) throws ExecutionControl.NotImplementedException;

    protected abstract List<TroopsComposite> getChildren() throws ExecutionControl.NotImplementedException;

    protected abstract void remove(TroopsComposite troopsComposite) throws ExecutionControl.NotImplementedException;

    protected abstract void print();
}

//军，节点类/容器
class Army extends TroopsComposite {

    private String name;
    private List<TroopsComposite> troopsComposites = new ArrayList<>();

    public Army(String name){
        this.name = name;
    }

    @Override
    public void add(TroopsComposite troopsComposite) {
        troopsComposites.add(troopsComposite);
    }

    @Override
    public List<TroopsComposite> getChildren() {
        return troopsComposites;
    }

    @Override
    public void remove(TroopsComposite troopsComposite) {
        troopsComposites.remove(troopsComposite);
    }

    @Override
    public void print() {
        System.out.println("---军---，名字：" + name);
        for(TroopsComposite item: troopsComposites){
            item.print();
        }
    }
}

//旅，节点类/容器
class Force extends TroopsComposite {

    private String name;
    private List<TroopsComposite> troopsComposites = new ArrayList<>();

    public Force(String name){
        this.name = name;
    }

    @Override
    public void add(TroopsComposite troopsComposite) {
        troopsComposites.add(troopsComposite);
    }

    @Override
    public List<TroopsComposite> getChildren() {
        return troopsComposites;
    }

    @Override
    public void remove(TroopsComposite troopsComposite) {
        troopsComposites.remove(troopsComposite);
    }

    @Override
    public void print() {
        System.out.println("-----旅-----，名字是：" + name);
        for(TroopsComposite item: troopsComposites){
            item.print();
        }
    }
}

//团，节点类/容器
class Roll extends TroopsComposite{

    private String name;
    private List<TroopsComposite> troopsComposites = new ArrayList<>();

    public Roll(String name){
        this.name = name;
    }

    @Override
    public void add(TroopsComposite troopsComposite) {
        troopsComposites.add(troopsComposite);
    }

    @Override
    public List<TroopsComposite> getChildren() {
        return troopsComposites;
    }

    @Override
    public void remove(TroopsComposite troopsComposite) {
        troopsComposites.remove(troopsComposite);
    }

    @Override
    public void print() {
        System.out.println("-------团-------，名字是：" + name);
        for(TroopsComposite item: troopsComposites){
            item.print();
        }
    }
}

//军人
class Soldier extends TroopsComposite{

    private String name;

    public Soldier(String name){
        this.name = name;
    }

    @Override
    public void add(TroopsComposite troopsComposite) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("没有实现");
    }

    @Override
    public List<TroopsComposite> getChildren() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("没有实现");
    }

    @Override
    public void remove(TroopsComposite troopsComposite) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("没有实现");
    }

    @Override
    public void print() {
        System.out.println("---------军人---------，名字是：" + name);
    }
}
