package com.kennedy;

/**
 * Created by adixith on 1/3/17.
 */
public class SingleDimArrayDp {
    public static void main(String[] args) {
        int[] arr = new SingleDimArrayDp().getOneDimArrayFillRandom(20, 10, 100);
        new SingleDimArrayDp().exp1(arr);
    }

    public void exp1(int arr[]) {
        printArray(arr);
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for(int i=1; i < arr.length; i++) {
            if(arr[i] > dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            else
                dp[i] = arr[i];
        }
        printArray(dp);
    }

    public void printArray(int[] arr) {
        for(int i:arr)
            System.out.print(i + "\t");
        System.out.println();
    }

    public int[] getOneDimArray(int size) {
        return new int[size];
    }

    public int[] getOneDimArrayFillRandom(int size, int upperLimit) {
        int arr[] = new int[size];
        for(int i=0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * upperLimit);
        }
        return arr;
    }

    public int[] getOneDimArrayFillRandom(int size, int lowerLimit, int upperLimit) {
        int arr[] = new int[size];
        for(int i=0; i < arr.length; i++) {
            arr[i] = lowerLimit + (int)(Math.random() * (upperLimit-lowerLimit));
        }
        return arr;
    }
}
