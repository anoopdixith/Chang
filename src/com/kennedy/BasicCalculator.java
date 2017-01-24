package com.kennedy;

import java.util.Stack;

/**
 * Created by adixith on 12/17/16.
 */
public class BasicCalculator {
    public static void main(String args[]) {
        String query = "2 + 7";
        int result = new BasicCalculator().evaluate(query);
        System.out.print(result);
    }

    protected int evaluate(String query) {
        int result = 0;
        int sign = +1;
        int number = 0;
        char[] queryChars = query.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i< queryChars.length; i++) {
            char c = queryChars[i];
            if(Character.isDigit(c)) {
                number = number*10 + (c-'0');
            }
            else if(c == '+') {
                result = result + (sign*number);
                number =0;
                sign = 1;
            }
            else if(c == '-') {
                result = result + (sign * number);
                sign = -1;
                number = 0;
            }
            else if(c == '(') {
                number = 0;
                sign = 1;
                stack.push(result);
                stack.push(sign);
            }
            else if(c == ')') {
                result = result + (sign * number);
                result = result * stack.pop();
                result = result + stack.pop();
                number = 0;
            }
        }
        result = result + (sign * number);
        return result;
    }
}
