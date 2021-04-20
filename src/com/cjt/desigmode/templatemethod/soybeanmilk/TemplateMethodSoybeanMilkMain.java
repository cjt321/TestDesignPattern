package com.cjt.desigmode.templatemethod.soybeanmilk;

/**
 * 模板方法。
 *
 * 角色：
 * 抽象模板类：负责统一模板方法，统一步骤。
 * 模板实现类：实现步骤具体细节。后者没有此步骤不实现。
 *
 * 例子：豆浆AbsSoybeanMilk
 * 编写制作豆浆的程序，说明如下:
 * 制作（make）豆浆的流程： 选材（selection）--->添加配料（addTheIngredients）--->浸泡（steep）--->放到豆浆机打碎（smash）。
 * 通过添加不同的配料，可以制作出不同口味的豆浆。
 * 选材、浸泡和放到豆浆机打碎这几个步骤对于制作每种口味的豆浆都是一样的(红豆（OrmosiaSoybeanMilk）、花生豆浆（PeanutSoybeanMilk）。。。)
 *
 */
public class TemplateMethodSoybeanMilkMain {

    public static void main(String[] args) {
        //花生豆浆
        AbsSoybeanMilk peanutSoybeanMilk = new PeanutSoybeanMilk();
        peanutSoybeanMilk.make();

        //红豆
        AbsSoybeanMilk ormosiaSoybeanMilk = new OrmosiaSoybeanMilk();
        ormosiaSoybeanMilk.make();
    }
}

//抽象模板方法，豆浆
abstract class AbsSoybeanMilk{
    //制作方法
    public final void make(){
        selection();
        if(hasAddTheIngredients())
            addTheIngredients();
        steep();
        smash();
    }

    //钩子方法，是否需要添加配料。
    protected boolean hasAddTheIngredients() {
        return true;
    }

    //选材
    protected void selection(){
        System.out.println("---豆浆选材---");
    }

    //添加配料
    protected void addTheIngredients(){
        System.out.println("---豆浆添加配料---");
    }

    //浸泡
    protected abstract void steep();

    //放到豆浆机打碎
    protected abstract void smash();
}

//红豆
class OrmosiaSoybeanMilk extends AbsSoybeanMilk{

    @Override
    protected boolean hasAddTheIngredients() {
        return false;
    }

    @Override
    protected void steep() {
        System.out.println("---红豆：浸泡---");
    }

    @Override
    protected void smash() {
        System.out.println("---红豆：放到豆浆机打碎---");
    }
}

//花生豆浆
class PeanutSoybeanMilk extends AbsSoybeanMilk{

    @Override
    protected void addTheIngredients() {
        System.out.println("---花生豆浆：添加配料---");
    }

    @Override
    protected void steep() {
        System.out.println("---花生豆浆：浸泡---");
    }

    @Override
    protected void smash() {
        System.out.println("---花生豆浆：放到豆浆机打碎---");
    }
}