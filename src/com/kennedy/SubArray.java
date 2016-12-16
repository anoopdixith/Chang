package com.kennedy;

/**
 * Created by adixith on 11/6/16.
 */
public class SubArray {
    public static void main(String args[]) {
        new SubArray().subArraySumToK(new int[]{1, 4, 0, 0, 3, 10, 5}, 7);
    }
    private void subArraySumToK(int[] arr, int k) {
        int currentSum = arr[0];
        int start = 0;
        for(int i=1; i < arr.length; i++) {
            Utils.p("====================\n Current sum is " + currentSum);
            while(currentSum > k && start < i-1) {
                Utils.p(" i is " + arr[i] + " start is " + arr[start]);
                currentSum -= arr[start++];
            }
            if(currentSum == k) {
                Utils.p("Found: " + arr[start] + " to " + arr[i-1]);
            }
            if(i < arr.length){
                currentSum += arr[i];
            }
        }
    }
}
