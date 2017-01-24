package com.kennedy;

/**
 * Created by adixith on 1/2/17.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 12321;
        Boolean isPalin = new PalindromeNumber().isPalindrome(number);
        System.out.println(isPalin);
    }

    public Boolean isPalindrome(int number) {
        int digits = 0;
        int originalNumber = number;
        while(number > 0) {
            number /= 10;
            digits++;
        }
        digits--;
        System.out.println("Digits is " + digits);
        while(originalNumber > 0) {
            int a = originalNumber % 10;
            int c = (int)Math.pow(10, digits);
            int b = (originalNumber / c);
            System.out.println(" a ia " + a);
            System.out.println(" b is " + b);
            System.out.println(" c is " + c);

            if(a != b) {
                System.out.println("Returning false");
                return false;
            }
            System.out.println("true");
            originalNumber /= 10;
            digits--;
        }
        return true;
    }
}
