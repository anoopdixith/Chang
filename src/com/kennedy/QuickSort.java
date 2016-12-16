package com.kennedy;

import java.util.Arrays;

/**
 * Created by adixith on 11/2/16.
 */
public class QuickSort {
    int[] a;
    public QuickSort(int[] a) {
        this.a = a;
    }
    /*
    {2,8,1,<6>,4,3}
     */
    private int[] quickSort(int start, int end) {
        System.out.println(start + " " + end + " diff is " + (end - start));
        if(end - start < 2) return a;
        int pivot = (end - start)/2;
        for(int i=start; i < end; i++) {
            if(a[i] > a[pivot] && i < pivot) {
                int temp = a[i];
                for(int j=i; j < pivot; j++) {
                    a[j] = a[j+1];
                }
                a[pivot] = temp;
                pivot = pivot - 1;
            }
            else if(a[i] < a[pivot] && i > pivot) {
                int temp = a[i];
                for(int j=i; j > pivot; j--) {
                        a[j] = a[j-1];
                    }
                    a[pivot] = temp;
                    pivot = pivot + 1;
            }
            //System.out.println(Arrays.toString(a));
        }
        quickSort(start, pivot);
        quickSort(pivot + 1, end);
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,8,1,6,4,3};
        QuickSort quick = new QuickSort(a);
        System.out.println(Arrays.toString(quick.quickSortLite(0, 5)));
    }

    private int[] quickSortLite(int low, int high) {
        if(low < high) {
            int partition = findPartition(low, high);
            quickSortLite(low, partition);
            quickSortLite(partition + 1, high);
        }
        return a;
    }

    private int findPartition(int low, int high) {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            }
            while(a[i] < pivot);
            do {
                j--;
            }
            while(a[i] > pivot);
            if(i>=j)
                return j;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            return pivot;
        }
    }
}
