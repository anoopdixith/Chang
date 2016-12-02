package com.kennedy;

/**
 * Created by adixith on 10/28/16.
 */
public class ReverseString {
    private String inputString = "";
    public ReverseString(String string) {
        this.inputString = string;
    }

    protected String reverseString() {
        char[] inputChar = inputString.toCharArray();
        for(int i=0; i < inputString.length()/2; i++) {
            char temp = inputChar[i];
            inputChar[i] = inputChar[inputChar.length - i -1];
            inputChar[inputChar.length - i - 1] = temp;
        }
        return new String(inputChar);
    }

}
