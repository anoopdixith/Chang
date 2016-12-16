package com.kennedy;

import java.util.Arrays;

/**
 * Created by adixith on 10/30/16.
 */
/*
public class MergeSort {
    public static void main(String a[]) {
        int[] arr = new int[]{16,3, 5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSort(array, tmp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] tmp, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            //System.out.println(Arrays.toString(tmp));
            int center = startIndex + (endIndex - startIndex) / 2;
            mergeSort(array, tmp, startIndex, center);
            mergeSort(array, tmp, center+1, endIndex);
            merge(array, tmp, startIndex, center+1, endIndex);
        }
    }

    private static void merge(int[] arr, int[] tmp, int startIndex, int center, int endIndex) {
        //System.out.println(Arrays.toString(arr));
        int i = startIndex;
        int j = center+1;
        int k = startIndex;
        while(i <= center && j <= endIndex) {
            //System.out.println(i + " " + j + " ");
            if(arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            }
            else {
                tmp[k++] = arr[j++];
            }
        }
        while(i <= center) {
            tmp[k++] = arr[i++];
        }
        while(j <= endIndex) {
            tmp[k++] = arr[j++];
        }
        for(int c=0; c < tmp.length; c++) {
            arr[c] = tmp[c];
        }
    }
}
*/
public class MergeSort
{
    public static void main(String[] args)
    {
        Integer[] a = {2, 6, 3, 5, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(Comparable [ ] a)
    {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }


    private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}