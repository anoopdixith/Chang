package com.kennedy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by adixith on 1/16/17.
 */
public class Ru {
    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void println() {
        System.out.println("New Line");
    }

    public static void meanwhile(String className, String methodName) {
        try {
            Class objectClass = Class.forName(className);
            Method runnableMethod = objectClass.getDeclaredMethod(methodName);
            runnableMethod.setAccessible(true);
            new Thread(() -> {
                try {
                    runnableMethod.invoke(objectClass);
                } catch (IllegalAccessException iAE) {
                    iAE.printStackTrace();
                } catch (InvocationTargetException iTE) {
                    iTE.printStackTrace();
                }
            }
            ).start();
        } catch (ClassNotFoundException cNF) {
            cNF.printStackTrace();
        } catch (NoSuchMethodException nM) {
            nM.printStackTrace();
        }
    }

    /* A way to test Ru */
    public static void main(String args[]) {
            meanwhile("com.EasyUtil.Ru", "println");
    }
}
