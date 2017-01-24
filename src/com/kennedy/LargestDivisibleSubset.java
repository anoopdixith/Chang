package com.kennedy;

/**
 * Created by adixith on 1/2/17.
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,8};
        int[] largestSubset = new LargestDivisibleSubset().getLargestSubset(arr);
        for(int i: largestSubset)
            System.out.print(i + "\t");
    }

    public int[] getLargestSubset(int[] arr) {
        return arr;
    }
}
