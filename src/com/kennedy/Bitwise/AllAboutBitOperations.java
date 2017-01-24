package com.kennedy.Bitwise;

import com.kennedy.BaseConversion;

/**
 * Created by adixith on 12/27/16.
 */
public class AllAboutBitOperations extends BaseConversion{
    public static void main(String args[]) {
        char ch = new AllAboutBitOperations().convertIntToChar(5);
        //System.out.println("char is " + ch);

        int digit = new AllAboutBitOperations().convertCharToInt('8');
        //System.out.println("digit is " + digit);

        //new AllAboutBitOperations().toLower("helloWorldThisISmixed");

        //boolean oppSigns = new AllAboutBitOperations().oppositeSigns(-3, 5);
        //System.out.println(oppSigns);

        int input = 15;
        int bitSet = new AllAboutBitOperations().countBitSet(input);
        System.out.println("Bits set in " + input + " is " + bitSet);
        int bitSetBrian = new AllAboutBitOperations().countBitSetBrianWay(input);
        System.out.println("Bits set in " + input + " in Brian way is " + bitSetBrian);


    }

    public void toLower(String upperCase) {
        char[] upper = upperCase.toCharArray();
        char[] lower = new char[upperCase.length()];
        char[] flip = new char[upperCase.length()];
        int i=0;
        for(char c:upper) {
            char lowerCh = (char)(c | ' ');
            char flipCh = (char)(c ^ ' ');
            lower[i] = lowerCh;
            flip[i++] = flipCh;
        }

        for(char j:lower)
            System.out.print(j);
        System.out.println();
        for(char j:flip)
            System.out.print(j);
        System.out.println();
    }

    // convert, for example 3 to '3'
    public char convertIntToChar(int digit) {
        return (char)(digit + 48);
    }

    // convert, for example '3' to 3
    public int convertCharToInt(char digit) {
        return digit - '0';
    }

    public boolean oppositeSigns(int first, int second) {
        String inBinaryFirst = new BaseConversion().convert((long)first, 10, 2);
        String inBinarySecond = new BaseConversion().convert((long)second, 10, 2);
        String inBinaryResult = new BaseConversion().convert((long)first^second, 10, 2);
        System.out.println("First is " + inBinaryFirst);
        System.out.println("Second is " + inBinarySecond);
        System.out.println("Result is " + inBinaryResult);
        return ((first ^ second) < 0);
    }

    public int countBitSet(int v) {
        int c =0;
        while(v > 0) {
            c += v&1;
            v >>= 1;
        }
        return c;
    }

    public int countBitSetBrianWay(int v) {
        int c = 0;
        while(v > 0) {
            v &= v-1;
            c++;
        }
        return c;
    }
}
