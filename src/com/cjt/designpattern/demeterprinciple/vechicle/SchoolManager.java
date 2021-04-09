package com.cjt.designpattern.demeterprinciple.vechicle;

import java.util.ArrayList;
import java.util.List;

public class SchoolManager {

    //返回学校总部的员工
    private List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) { //这里我们增加了 5 个员工到 list
            Employee emp = new Employee();
            emp.setId("学校总部员工 id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void printAllEmployee(CollegeManager sub) {
        //获取到学院员工
        sub.printEmployee();
        /*List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }*/
        //获取到学校总部员工
        printEmployee();
        /*List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }*/
    }

    private void printEmployee(){
        List<Employee> list = getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list) {
            System.out.println(e.getId());
        }
    }
}
