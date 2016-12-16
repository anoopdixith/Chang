package com.kennedy;

import java.util.Arrays;

/**
 * Created by adixith on 11/5/16.
 */
public class BalancedNegPosArray {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(new BalancedNegPosArray().balance(new int[]{1,2,3,-4,-1,4})));
    }

    private int[] balance(int a[]) {
        for(int i=0; i < a.length; i++) {
            if(!isAtRightPlace(a, i)) {
                a = findReplacement(a, i);
            }
        }
        return a;
    }

    private Boolean isAtRightPlace(int[] a, int i) {
        return ((i%2==0 && a[i]<0) || (i%2==1 && a[i]>0));
    }

    private int[] findReplacement(int[] a, int i) {
        return a;
    }
}
