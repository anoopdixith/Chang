package com.kennedy.DesignPatterns.Factory;

/**
 * Created by adixith on 12/22/16.
 */
public class FactoryDemo {
    public static void main(String args[]) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("rectangle");
        Shape shape3 = shapeFactory.getShape("square");
        shape2.draw();
        shape3.draw();
    }
}
