package com.kennedy;

/**
 * Created by adixith on 12/1/16.
 */
public class BaseConversion {
    public String convert(Long number, int from, int to) {
        return (from == to)?number.toString():(from < to)?convertUp(number, from, to):convertDown(number, from, to);
    }

    private String convertUp(Long number, int from, int to) {
        Long runningResult = 0l;
        long runningExponent = 0;
        boolean sign = true;
        if(number < 0)
            sign = false;
        while(Math.abs(number) > 0) {
            long rem = number % to;
            runningResult += (long)(rem * Math.pow(from,runningExponent++));
            number /= to;
        }
        //Utils.p("Result " + runningResult.toString());
        if(!sign)
            runningResult = -runningResult;
        return runningResult.toString();
    }

    private String convertDown(Long number, int from, int to) {
        StringBuilder runningResult = new StringBuilder("");
        boolean sign = true;
        if(number < 0)
            sign = false;
        while(Math.abs(number) > 0) {
            Long rem = number % to;
            number /= to;
            runningResult.append(rem);
        }
        /*
        Classic example of problems with Mutation.
        StringBuilder (which is mutable) changes the
        string when it's used in the print statement with reverse().
        Output will be returned wrong.
         */
        //Utils.p("Result " + runningResult.reverse().toString());
        return runningResult.reverse().toString();
    }
}
