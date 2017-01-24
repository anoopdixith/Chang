package com.kennedy;

/**
 * Created by adixith on 1/9/17.
 */
public class Point {
    int x;
    int y;
    public Point() {
        this(0,0);
    }
    public Point(int x) {
        this(x, 0);
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
