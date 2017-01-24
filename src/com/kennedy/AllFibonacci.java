package com.kennedy;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

/**
 * Created by adixith on 12/20/16.
 */
public class AllFibonacci<T>{
    public static void main(String args[]) {
        try {
            List<Integer> allFibonacciNumbersUntil = new AllFibonacci().findAllFibonacciNumbersUntil(50);
            new AllFibonacci<Integer>().printList(allFibonacciNumbersUntil);

            int upperLimit = 3;
            int upperLimitthFibNumber = new AllFibonacci<Integer>().findAllFibonacciNumbersByRecursionUntil(upperLimit);
            System.out.println("\n" + upperLimit + "th" + " Fib number is " + upperLimitthFibNumber);

            //int upperLimitthFibNumberIter = new AllFibonacci<Integer>().findNthFibonacciNumber(upperLimit);
            //System.out.println("\n" + upperLimit + "th" + " Fib number via iter is " + upperLimitthFibNumberIter);

            //int upperLimitthFibNumberDp = new AllFibonacci<Integer>().findNthFibonacciNumberDp(upperLimit);
            //System.out.println("\n" + upperLimit + "th" + " Fib number via dp is " + upperLimitthFibNumberDp);

            //int upperLimitthFibNumberDpOptimized = new AllFibonacci<Integer>().findNthFibonacciNumberDpOptimized(upperLimit);
            //System.out.println("\n" + upperLimit + "th" + " Fib number via dp optimized is " + upperLimitthFibNumberDpOptimized);


        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    private void printList(List<T> inputList) {
        for(T t:inputList) {
            System.out.print(t + " ");
        }
    }

    public List<Integer> findAllFibonacciNumbersUntil(int upperLimit) throws Exception{
        List<Integer> allFibonacciNumbers = new ArrayList<>();
        if(upperLimit < 1)
            throw new InvalidPropertiesFormatException("UpperLimit should be more than 0");
        int current = 0;
        int next = 1;

        while(true) {
            next += current;
            current = next - current;
            if(next > upperLimit) return allFibonacciNumbers;
            allFibonacciNumbers.add(next);
        }
    }

    public int findAllFibonacciNumbersByRecursionUntil(int upperLimit) throws Exception {
        System.out.println("Fib Call");
        System.out.println("upperLimit is " + upperLimit);
        if(upperLimit <= 1)
            return 1;
        else
            return (findAllFibonacciNumbersByRecursionUntil(upperLimit - 1) + findAllFibonacciNumbersByRecursionUntil(upperLimit - 2));
    }

    public int findNthFibonacciNumber(int n) {
        int previous =1; int current = 1;
        for(int i=0; i < n; i++) {
            current += previous;
            previous = current - previous;
        }
        return previous;
    }

    public int findNthFibonacciNumberDp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i =2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int findNthFibonacciNumberDpOptimized(int n) {
        int[] dp = new int[2];
        dp[0] = 1; dp[1] = 1;
        int i =0;
        while(i++ < n){
            dp[i%2] = dp[i%2] + dp[(i+1)%2];
        }
        return dp[(n+1)%2];
    }
}
