package com.kennedy;

/**
 * Created by adixith on 12/19/16.
 */
public class Leetcode229 {
    public static void main(String args[]) {
        int[] input = {2,3,1,2,4,2,2,2,6};
        new Leetcode229().findElementWithNBy3Repititions(input);
        new Leetcode229().findElementWithNBy2Repititions(input);
    }

    private void findElementWithNBy3Repititions(int[] input) {
        int number1 = input[0];
        int number2 = input[0];
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i < input.length; i++) {
            if(input[i] == number1) {
                count1++;
            }
            else if(input[i] == number2) {
                count2++;
            }
            else if(count1 == 0) {
                count1++;
                number1 = input[i];
            }
            else if(count2 == 0) {
                count2++;
                number2 = input[i];
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 =0;
            for(int i:input) {
                if(i == number1)
                    count1++;
                else if(i == number2)
                    count2++;
            }
        if(count1 > input.length/3)
            System.out.println(number1);
        if(count2 > input.length/3)
            System.out.println(number2);

    }

    private void findElementWithNBy2Repititions(int[] input) {
        int number1 = input[0];
        int count1 = 0;
        for(int i=0; i < input.length; i++) {
            if(input[i] == number1) {
                count1++;
            }
            else if(count1 == 0) {
                count1++;
                number1 = input[i];
            }
            else
                count1--;
        }
        count1 = 0;
        for(int i:input) {
            if(i == number1)
                count1++;
        }
        if(count1 > input.length/3)
            System.out.println(number1);
    }
}
