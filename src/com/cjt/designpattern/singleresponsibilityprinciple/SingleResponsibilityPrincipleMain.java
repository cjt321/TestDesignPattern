package com.cjt.designpattern.singleresponsibilityprinciple;

import com.cjt.designpattern.singleresponsibilityprinciple.vehicle.AirVehicle;
import com.cjt.designpattern.singleresponsibilityprinciple.vehicle.RoadVehicle;
import com.cjt.designpattern.singleresponsibilityprinciple.vehicle.WaterVechicle;

/***
 * 单一职责原则。
 * 一个类只负责一种职责。如果类方法太少，可以用方法实现。
 */
public class SingleResponsibilityPrincipleMain {

    public static void main(String[] args) {
        new RoadVehicle().vehicle("汽车");
        new AirVehicle().vechicle("飞机");
        new WaterVechicle().vechicle("轮船");

    }

}


