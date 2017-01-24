package com.kennedy;

/**
 * Created by adixith on 12/18/16.
 */
public class kRepeatedNumber {
    public static void main(String argsp[]) {
        int[] input = {2,9,2,5,7, 2,5,7,8,7,9,5,1,1,9,1};
        int numberOfAppearances = 2;
        int oddManOut = new kRepeatedNumber().findNumberAppearsOnce(input, numberOfAppearances);
        System.out.println(oddManOut);
    }

    private int findNumberAppearsOnce(int[] input, int numberOfAppearances) {
        int result = 0;
        if(numberOfAppearances % 2 == 0)
            for(int i:input)
                result ^= i;
        else {

        }
        return result;
    }
}
