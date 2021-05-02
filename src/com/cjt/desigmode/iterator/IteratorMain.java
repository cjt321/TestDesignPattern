package com.cjt.desigmode.iterator;

import java.util.*;

/**
 * 迭代器模式
 *
 * 例子：遍历不同学院，学院下面有不同专业。不同院校实现的专业方式不用，有数组，有集合。
 * 院校（College）与专业（Major）关系：
 *  ---计算机学院（ComputerCollege）：java工程师、大数据工程师、前端工程师、信息安全
 *  ---信息工程学院（InfoEngCollege）：网络信息安全、电子技术
 *
 */
public class IteratorMain {

    public static void main(String[] args) {
        List<ICollegeAggreate> collegeAggreates = new ArrayList<>();
        collegeAggreates.add(new ComputerCollegeAggreate());
        collegeAggreates.add(new InfoEngCollegeAggreate());

        var outputImpl = new OutputImpl(collegeAggreates);
        outputImpl.printCollege();
    }
}

//元素，专业
class Major{
    private String name;

    public Major(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//计算机专业遍历器
class ComputerCollegeIterator implements Iterator {

    private List<Major> majors;
    private int idx = 0;

    public ComputerCollegeIterator(List<Major> majors) {
        this.majors = majors;
    }

    @Override
    public boolean hasNext() {
        if(idx >= majors.size())
            return false;
        //idx ++;
        return true;
    }

    @Override
    public Object next() {
        var result = majors.get(idx);
        idx ++;
        return result;
    }
}

//信息工程学院遍历器
class InfoEngCollegeIterator implements Iterator {

    private Major[] majors;
    private int idx = 0;

    public InfoEngCollegeIterator(Major[] majors) {
        this.majors = majors;
    }

    @Override
    public boolean hasNext() {
        if(idx >= majors.length)
            return false;
        return true;
    }

    @Override
    public Object next() {
        var result = majors[idx];
        idx ++;
        return result;
    }
}

//学院聚合接口，具体实现逻辑
interface ICollegeAggreate{

    Iterator createIterator();
    void printMajor(Iterator iterator);
    String getName();
}

//计算机学院聚合
class ComputerCollegeAggreate implements ICollegeAggreate {

    private List<Major> majors;

    public ComputerCollegeAggreate(){
        majors = new ArrayList<>();
        majors.add(new Major("java工程师"));
        majors.add(new Major("大数据工程师"));
        majors.add(new Major("前端工程师"));
        majors.add(new Major("信息安全"));
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(majors);
    }

    @Override
    public void printMajor(Iterator iterator) {
        while (iterator.hasNext()) {
            Major item = (Major) iterator.next();
            System.out.println("----计算机学院专业："+ item.getName() + "----");
        }
    }

    @Override
    public String getName() {
        return "===计算机学院===";
    }
}

//信息工程学院聚合
class InfoEngCollegeAggreate implements ICollegeAggreate {

    private Major[] majors;

    public InfoEngCollegeAggreate(){
        majors = new Major[2];
        majors[0] = new Major("网络信息安全");
        majors[1] = new Major("电子技术");
    }

    @Override
    public Iterator createIterator() {
        return new InfoEngCollegeIterator(majors);
    }

    @Override
    public void printMajor(Iterator iterator) {
        while (iterator.hasNext()){
            Major item = (Major) iterator.next();
            System.out.println("----信息工程学院专业："+ item.getName() + "----");
        }
    }

    @Override
    public String getName() {
        return "===信息工程学院===";
    }
}

class OutputImpl {
    private List<ICollegeAggreate> collegeAggreates;

    public OutputImpl(List<ICollegeAggreate> collegeAggreates){
        this.collegeAggreates = collegeAggreates;
    }

    public void printCollege(){
        for (var item: collegeAggreates){
            var iterator = item.createIterator();
            System.out.println(item.getName());
            while (iterator.hasNext()){
                item.printMajor(iterator);
            }
        }
    }
}