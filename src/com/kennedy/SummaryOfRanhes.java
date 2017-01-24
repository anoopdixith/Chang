package com.kennedy;

/**
 * Created by adixith on 12/17/16.
 */
public class SummaryOfRanhes {

    public static void main(String args[]) {
        int[] inputArray = {0,1,2,3,4,5,6,7};
        String summary[] = new SummaryOfRanhes().findSummary(inputArray);
        for(String str:summary)
            if(str != null)
                System.out.println(str);
    }

    protected String[] findSummary(int[] input) {
        String[] range = new String[input.length];
        int k=0;
        for(int i=0; i < input.length-1;) {
            int start = i;
            while((input[i+1] - input[i++] == 1) && (i < input.length -1));
            range[k++] = input[start] + "->" + input[i-1];
            if(i == input.length -1)
                if(input[i] - input[i-1] == 1)
                    range[k-1] = input[start] + "->" + input[i];
                else
                    range[k] = input[i] + "";
        }

        return range;
    }
}
