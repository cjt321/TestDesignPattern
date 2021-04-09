package com.cjt.designpattern.openclosedprinciple;

import com.cjt.designpattern.openclosedprinciple.realize.Circle;
import com.cjt.designpattern.openclosedprinciple.realize.GraphicEditer;
import com.cjt.designpattern.openclosedprinciple.realize.Retangle;
import com.cjt.designpattern.openclosedprinciple.realize.Rhombus;

public class OpenClosedPrincipleMain {

    public static void main(String[] args) {
        var graphicEditer = new GraphicEditer();
        graphicEditer.draw(new Circle());
        graphicEditer.draw(new Retangle());
        graphicEditer.draw(new Rhombus());
    }

}
