package com.kennedy;

/**
 * Created by adixith on 12/24/16.
 */
public class MaximumContigiousProductArray {
    public static void main(String args[]) {
        int[] input1 = new int[]{2,-3,3,4,3, -2};
        int[] input2 = new int[]{2,3,-1,4};
        int[] input3 = new int[]{-2,3,-1,4};
        int maxContiguousProduct = new MaximumContigiousProductArray().findMaxContiguousProduct(input1);

        System.out.println(maxContiguousProduct);
    }

    private int findMaxContiguousProduct(int[] input) {
        if(input.length == 0)
            throw new IllegalArgumentException();
        int maxProduct = input[0];
        int runningProduct = 1;
        int runningProductBeforeNegative = 1;
        for(int i:input) {
            if(i == 0) return 0;
            runningProduct *= i;
            if(runningProduct >= maxProduct)
                maxProduct = runningProduct;
            else if(runningProduct < 0) {

                runningProductBeforeNegative = runningProduct;
                runningProduct = 1;
            }
        }
        return maxProduct;
    }
}
