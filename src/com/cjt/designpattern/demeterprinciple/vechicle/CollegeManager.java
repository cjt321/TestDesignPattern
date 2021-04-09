package com.cjt.designpattern.demeterprinciple.vechicle;

import java.util.ArrayList;
import java.util.List;

public class CollegeManager {

    //返回学院的所有员工
    private List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //这里我们增加了 10 个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工 id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void printEmployee(){
        System.out.println("---学院员工---");
        for (var item : getAllEmployee()) {
            System.out.println(item.getId());
        }
    }

}
