package com.kennedy;

/**
 * Created by adixith on 12/7/16.
 */
public class StringToFloat {
    protected float toFloat(String input) {
        String[] parts = input.split("\\.");
        if(parts.length == 1) {
            return (float)stringToInt(input);
        }
        if(parts.length == 2) {
            float decimal = stringToInt(input.split("\\.")[0]);
            float mantissa = stringToInt(input.split("\\.")[1]);
            return (float) (decimal + (mantissa / (Math.pow(10, input.split("\\.")[1].length()))));
        }
        throw new NumberFormatException();
    }

    private int stringToInt(String input) {
        //System.out.println("Input is " + input);
        if(input.length() == 0 || (input.length() == 1 && input.charAt(0) == '-'))
            throw new NumberFormatException();
        char[] value = input.toCharArray();
        int number = 0;
        int exponent = 0;
        for(int i=value.length-1; i >=0; i--) {
            //System.out.println(value[i]-'0');
            if(i == 0 && value[i] == '-') {
                number = -number;
                return number;
            }
            if(i > 0 && (value[i]-'0' < 0 || value[i]-'0' > 9))
                throw new NumberFormatException("String not parse-able as float");
            number += (value[i] - '0') * Math.pow(10, exponent++);
            if(number < 0)
                throw new ArithmeticException("Number too big or small");
        }
        return number;
    }

    public static void main(String args[]) {
        System.out.println(new StringToFloat().toFloat("1223.4"));
    }
}
