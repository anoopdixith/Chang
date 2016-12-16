package com.kennedy;

import java.util.Arrays;

/**
 * Created by adixith on 10/30/16.
 */
public class MaxSecondMaxMinSecondMin {
    private int[] findThem(int[] array) {
        int max, secondMax, thirdMax, min, secondMin;
        max = secondMax = thirdMax = min = secondMin = array[0];
        for(int i: array) {
            if(i>max) {
                max = i;
            }
            else if(i > secondMax) {
                secondMax = i;
            }
            else if(i > thirdMax) {
                thirdMax = i;
            }
            else if(i < min) {
                min = i;
            }
            else if(i < secondMin) {
                secondMin = i;
            }
        }
        return new int[]{max, secondMax, thirdMax, min, secondMin};
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(new MaxSecondMaxMinSecondMin().findThem(new int[]{5,19, -6, 4, 7})));
    }
}
