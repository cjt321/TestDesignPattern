package com.cjt.designpattern.demeterprinciple;

import com.cjt.designpattern.demeterprinciple.vechicle.CollegeManager;
import com.cjt.designpattern.demeterprinciple.vechicle.SchoolManager;

/**
 * 迪米特法则（最小知道法则）
 *  1.依赖其他类时，不需要知道他们的具体实现，只需要知道怎么用。
 *  2.非直接朋友变成直接朋友关系。即在方法使用时，如果不是方法参数、成员变量、方法返回值，则删除。
 *      直接朋友：成员变量、方发参数、方法返回值
 *      非直接朋友：方法中，非返回参数、非方法参数、非成员变量
 */
public class DemeterPrincipleMain {

    public static void main(String[] args) {
        CollegeManager collegeManager = new CollegeManager();
        SchoolManager schoolManager = new SchoolManager();

        schoolManager.printAllEmployee(collegeManager);
    }

}
