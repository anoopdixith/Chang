package com.kennedy;

/**
 * Created by adixith on 10/30/16.
 */
public class Kadane {
    private static int maxSumSubarray(int[] array) {
        int maxTillHere = 0;
        int maxAtThisPoint = 0;
        for(int i=0; i < array.length; i++) {
            maxAtThisPoint = (maxAtThisPoint + array[i]) > 0? maxAtThisPoint+array[i] : 0;
            maxTillHere = maxAtThisPoint > maxTillHere ? maxAtThisPoint : maxTillHere;
        }
        return maxTillHere;
    }

    public static void main(String a[]) {
        System.out.println(new Kadane().maxSumSubarray(new int[]{3,-5,1,-6,4,7}));
    }
}
