package com.kennedy.DesignPatterns.Factory;

/**
 * Created by adixith on 12/22/16.
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if(shapeType == null)
            return null;
        if(shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        if(shapeType.equalsIgnoreCase("rectangle"))
            return new Rectangle();
        if(shapeType.equalsIgnoreCase("square"))
            return new Square();
        return null;
    }
}
