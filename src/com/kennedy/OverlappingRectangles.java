package com.kennedy;

/**
 * Created by adixith on 1/10/17.
 */
public class OverlappingRectangles {
    public static class Rectangle {
        double top;
        double right;
        double bottom;
        double left;
        public Rectangle(double left, double top, double right, double bottom) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
        }
    }
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 10, 17, 4);
        Rectangle r2 = new Rectangle(7, 14, 13, 0);
        Rectangle r3 = new Rectangle(37, 44, 53, 40);
        Rectangle r4 = new Rectangle(-3, 4, 3, -4);
    }

    public boolean areRectanglesOverlapping(Rectangle r1, Rectangle r2) {
        return false;
    }
}
