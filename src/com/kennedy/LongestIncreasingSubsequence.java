package com.kennedy;

/**
 * Created by adixith on 12/29/16.
    THIS IS WRONG. DON'T USE
 */

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int arr[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int lengthOfLongestIncreasingSubsequence = new LongestIncreasingSubsequence().getLengthOfLongestIncreasingSubsequence(arr);
        System.out.println();
        System.out.println(lengthOfLongestIncreasingSubsequence);
    }

    public int getLengthOfLongestIncreasingSubsequence(int[] arr) {
        int lengthOfLSS = 0;
        if(arr.length <= 1)
            return arr.length;
        int[] llcssEndingHere = new int[arr.length];
        llcssEndingHere[0] = 0;
        for(int i=1; i < arr.length; i++) {
            if(arr[i-1] < arr[i]) {
                llcssEndingHere[i] = llcssEndingHere[i-1] + 1;
            }
            else
                llcssEndingHere[i] = llcssEndingHere[i-1];
        }
        for(int i:llcssEndingHere) {
            System.out.print(i + ",");
            if(i > lengthOfLSS)
                lengthOfLSS = i;
        }
        return lengthOfLSS;
    }
}
