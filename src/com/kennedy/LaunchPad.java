package com.kennedy;
/**
 * Created by adixith on 10/28/16.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LaunchPad {
    private static int testCases = 0;
    private static int testCaseSuccesses = 0;
    private static int testCaseFailures = 0;
    private static int numberOfExceptions = 0;

    public static void main(String args[]) {
        /*
        Working?
         */
        isThisWorking();

        final List<String> listOfMethods = addTestableMethods();

        /*
        Run All Tests
         */
        try {
            Class<?> thisClass = Class.forName(LaunchPad.getClassName());
            Object thisClassInstance = thisClass.newInstance();
            Method[] methods = thisClass.getDeclaredMethods();
            for (String test : listOfMethods) {
                for (Method method : methods) {
                    if (method.getName().equals(test)) {
                        testCases++;
                        try {
                            method.invoke(thisClassInstance);
                        } catch(InvocationTargetException ite) {
                            StackTraceElement[] stackTraceElement = ite.getCause().getStackTrace();
                            Utils.neatTrace(stackTraceElement);
                            Utils.p(ite.getCause().getMessage(), "CYAN");
                            numberOfExceptions++;
                            Utils.p("============", "PURPLE");
                        }
                    }
                }
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        catch (InstantiationException e) {
            System.out.println(e.getMessage());
        }
        finally {
        }
        Utils.p("");
        Utils.p("Number of total test cases: " + testCases, "BLUE");
        Utils.p("Number of successful test case: " + testCaseSuccesses, "BLUE");
        Utils.p("Number of failed test cases: " + testCaseFailures, "BLUE");
        Utils.p("Number of exceptions: " + numberOfExceptions, "BLUE");
    }


    private static List<String> addTestableMethods() {
        List<String> listOfMethods = new ArrayList<String>();
        listOfMethods.add("testReverseString");
        listOfMethods.add("testBaseConversion");
        return listOfMethods;
    }

    private static String getClassName() {
        return "com.kennedy.LaunchPad";
    }

    private static int getRandomInteger(int upperLimit) {
        return new Random(upperLimit).nextInt();
    }

    private static Boolean getRandomBool() {
        return new Random(getRandomInteger(Integer.MAX_VALUE)).nextInt() %2 == 0;
    }

    private static void isThisWorking() {
        final String status = "YES, THIS IS WORKING";
        System.out.println(status);
    }

    //All these methods are called via reflection
    @SuppressWarnings("unused")
    private void testReverseString() {
        Utils.p("============", "PURPLE");
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("Testing: " + testName.substring(4)); // all test methods start with test substring
        String testString1 = new String("Houston! We have a problem.");
        boolean match = new ReverseString(testString1).reverseString().equals(".melborp a evah eW !notsuoH");
        output(testName, match);
        Utils.p("============", "PURPLE");
    }

    @SuppressWarnings("unused")
    private void testBaseConversion() {
        Utils.p("============", "PURPLE");
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("Testing: " + testName.substring(4)); // all test methods start with test substring
        boolean match = new BaseConversion().convert(11101101l, 2, 10).equals("237") &&
               new BaseConversion().convert(237l, 10, 2).equals("11101101");
        output(testName, match);
        Utils.p("============", "PURPLE");
    }

    private void output(String testName, Boolean match) {
        if(match) {
            Utils.p("SUCCESS: " + testName, "GREEN");
            testCaseSuccesses++;
        }
        else {
            Utils.p("FAILURE: " + testName, "RED");
            testCaseFailures++;
        }
    }
}
