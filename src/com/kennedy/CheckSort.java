package com.kennedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adixith on 1/13/17.
 */
public class CheckSort {
    static int numberOfLoops = 0;
    public static void main(String[] args) {
        int[] arr = getArray(10000, 0, 1000000);
        printArray(arr, 10);
        while(!isSorted(arr, true) && !isSorted(arr, false)) {
            numberOfLoops++;
            arr = checkSort(arr);
        }
        printArray(arr, 10);
        System.out.println("Loops taken: " + numberOfLoops);
    }

    public static void printArray(int[] arr, int lineWidth) {
        int width = 0;
        for(int i:arr) {
            System.out.print(i + ", ");
            width++;
            if(width == lineWidth) {
                System.out.println();
                width = 0;
            }
        }
        System.out.println();
        System.out.println();
    }

    public static int[] checkSort(int[] arr) {
        /*
        if(isSorted(arr, true) || isSorted(arr, false)) {
            return arr;
        }
        */
        List<Stack<Integer>> allBuckets = new ArrayList<>();
        Stack<Integer> bucket = new Stack<>();
        allBuckets.add(bucket);
        int index =0;
        for(int i:arr) {
            bucket = allBuckets.get(index);
            if(bucket.empty() || bucket.peek() < i)
                bucket.push(i);
            else {
                Stack<Integer> newBucket = new Stack<>();
                newBucket.add(i);
                allBuckets.add(newBucket);
                index++;
            }
        }
        index = 0;
        int[] result = new int[arr.length];
        boolean allEmpty = false;
        while(!allEmpty) {
            for (Stack<Integer> stack : allBuckets) {
                if (!stack.empty())
                    result[index++] = stack.pop();
            }
            allEmpty = true;
            for (Stack<Integer> stack : allBuckets) {
                if(!stack.empty()) {
                    allEmpty = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isSorted(int[] arr, boolean descending) {
        for(int i=0; i < arr.length - 1; i++) {
            if(descending && arr[i] < arr[i+1]) {
                return false;
            }
            if(!descending && arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    public static int[] getArray(int size, int minimum, int maximum) {
        int[] arr = new int[size];
        for(int i=0; i < size; i++) {
            arr[i] = minimum + (int)(Math.random() * (maximum - minimum));
        }
        return arr;
    }
}
