package com.kennedy;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by adixith on 11/5/16.
 */
public class ArrayAll {
    public static void main(String args[]) {
        int[] arr = new int[]{5,3,9,1,13,0,22};
        //new ArrayAll().printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
        //System.out.println(new ArrayAll().xorMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10));
        //new ArrayAll().printRepeatedElements(new int[]{7, 3, 4, 5, 5, 6, 2});
        new ArrayAll().findNumbersAddingUptoKMethod3(new int[]{2, 5, 1, 9, 6, 4}, 7);
    }

    private void printMissingNumber(int[] array, int expectedCount) {
        int missingCount = expectedCount - array.length;
        BitSet bitSet = new BitSet(expectedCount);
        for(int i:array)
            bitSet.set(i -1);
        int lastMissingIndex = 0;
        for(int i=0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    private int xorMissingNumber(int [] arr, int totalNumbers) {
        int allXor = 0;
        int arrXor = 0;
        for(int i=1; i <= totalNumbers; i++)
            allXor = allXor ^ i;
        for(int i=0; i < arr.length; i++)
            arrXor = arrXor ^ arr[i];
        return allXor ^ arrXor;
    }

    private void printRepeatedElements(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            if(arr[Math.abs(arr[i]) - 1] < 0)
                Utils.p(i+1);
            else
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }
        for(int i:arr)
            Utils.p(i);
    }

    public <T> Boolean contains(final T[] array, final T v) {
        for(T t:array) {
            if(t == v || v!=null && v.equals(t))
                return true;
        }
        return false;
    }

    private void findNumbersAddingUptoKMethod1(int arr[], int sum) {
        for(int i=0; i < arr.length; i++)
            for(int j=i+1; j<arr.length; j++)
                if(arr[i] + arr[j] == sum)
                    Utils.p(arr[i] + " " + arr[j] + " = " + sum);
    }

    private void findNumbersAddingUptoKMethod2(int arr[], int sum) {
        int[] temp = new int[arr.length];
        for(int i=0; i < arr.length; i++)
            temp[i] = sum - arr[i];
    }


    private void findNumbersAddingUptoKMethod3(int arr[], int sum) {
        Arrays.sort(arr);
        int i=0; int j = arr.length-1;
        while (i <j) {
            if(arr[i] + arr[j] == sum)
                Utils.p(arr[i++] + " " + arr[j++] + " = " + sum);
            else if(arr[i] + arr[j--] > sum){}
            else if(arr[i++] + arr[j] < sum) {}
        }
    }
}
