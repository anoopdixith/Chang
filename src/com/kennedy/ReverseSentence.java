package com.kennedy;

/**
 * Created by adixith on 12/7/16.
 */
public class ReverseSentence {
    public ReverseSentence(String string) {
        this.inputString = string;
    }
    String inputString;

    protected String reverseSentence(char separation) {
        this.reverseString(0, inputString.length()-1);
        for(int i=0, j=i; i < inputString.length();) {
            while(inputString.charAt(j++) != separation) {
                if(j == inputString.length()-1) {
                    reverseString(i, j);
                    return inputString;
                }
            }
            reverseString(i, j-2);
            i = j;
        }
        return inputString;
    }

    protected String reverseSentence() {
        return reverseSentence(' ');
    }

    //From from to to both included
    private void reverseString(int from, int to) {
        System.out.println("from is " + from + " to is " + to);
        char[] input = this.inputString.toCharArray();
        char[] substring = new char[to - from + 1];
        for(int i=0; i < substring.length; i++) {
            substring[i] = input[from++];
        }
        for(int i=0; i < substring.length/2; i++) {
            char temp = substring[i];
            substring[i] = substring[substring.length - i -1];
            substring[substring.length -1 -i] = temp;
        }
        from = from - substring.length;
        for(int i=0; i < substring.length; i++) {
            input[from++] = substring[i];
        }
        inputString = new String(input);
        System.out.println(inputString);
    }

    public static void main(String args[]) {
        System.out.println(new ReverseSentence("ab cd ef").reverseSentence());
    }
}
