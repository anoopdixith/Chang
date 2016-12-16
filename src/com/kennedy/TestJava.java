package com.kennedy;

/**
 * Created by adixith on 12/14/16.
 */
public class TestJava {
    public static void main(String args[]) {
        //System.out.println(new TestJava().gcd(5,10));
        System.out.println(new TestJava().minSubarrayLength(7, new int[]{2,3,1,2,4,3}));
    }

    protected int gcd(int a, int b) {
        return (b == 0)? a: gcd(b, a%b);
    }

    protected int minSubarrayLength(int s, int[] nums) {
        int sum = 0, from = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("---");
            System.out.println("i is " + i);
            System.out.println("sum is " + sum);
            while (sum >= s) {
                System.out.println("sum is > s at " + sum);
                min = Math.min(min, i - from + 1);
                sum -= nums[from++];
            }
            System.out.println("min is " + min);
            System.out.println("---");
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
