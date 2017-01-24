package com.kennedy;

/**
 * Created by adixith on 1/16/17.
 */
public class CheckThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread Running");
        };
        new Thread(task).start();
    }
}
