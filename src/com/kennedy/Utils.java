package com.kennedy;

/**
 * Created by adixith on 10/29/16.
 */
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void p() {
        System.out.println();
    }
    public static void p(String string) {
        System.out.println(string);
    }
    public static void p(int integer) {
        System.out.println(integer);
    }
    public static void p(Boolean bool) {
        System.out.println(bool.booleanValue());
    }
    public static void p(String string, String color) {
        switch (color) {
            case "GREEN":
                System.out.println(ANSI_GREEN + string + ANSI_RESET);
                break;
            case "RED":
                System.out.println(ANSI_RED + string + ANSI_RESET);
                break;
            case "BLUE":
                System.out.println(ANSI_BLUE + string + ANSI_RESET);
                break;
            case "YELLOW":
                System.out.println(ANSI_YELLOW + string + ANSI_RESET);
                break;
            case "CYAN":
                System.out.println(ANSI_CYAN + string + ANSI_RESET);
                break;
            case "PURPLE":
                System.out.println(ANSI_PURPLE + string + ANSI_RESET);
                break;
            default:
                p(string);
        }
    }
    public static void neatTrace(StackTraceElement[] stackTraceElements) {
        for(StackTraceElement element:stackTraceElements) {
            p(element.toString(), "CYAN");
        }
    }
}
