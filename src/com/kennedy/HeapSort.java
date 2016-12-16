package com.kennedy;

import java.util.Arrays;

/**
 */
class HeapSort {

    protected int[] heapSort(int[] arr) {
        return heapify(arr);
    }

    private int[] heapify(int[] arr) {
        for(int i=0; i < (arr.length -1)/2; i++) {
            arr = maxHeap(arr, i);
        }
        return arr;
    }

    private int[] maxHeap(int[] arr, int i) {
        int n = (arr.length - 1)/2;
        int left = 2*i;
        int right = 2*i + 1;
        int max = i;
        if(left <= n && arr[left] > arr[i])
            max = left;
        if(right <= n && arr[right] > arr[max])
            max = right;
        if(max != i) {
            arr = swap(arr, i, max);
            maxHeap(arr, i);
        }
        return arr;
    }

    private int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {2, 1, 8, 9, 5, 12, 7, 20, 16};
        new HeapSort().heapSort(arr);
        Utils.p(Arrays.toString(arr));
    }
}
