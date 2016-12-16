package com.kennedy;

/**
 * Created by adixith on 12/10/16.
 */
public class SimpleSearch {

    public int find(String nee, String hays) {
        int index = -1;
        char[] needle = nee.toCharArray();
        char[] haystack = hays.toCharArray();
        int i =0; int j = 0;
        for(i = 0; i < haystack.length; i++) {
            for(j =0; j < needle.length; j++) {
                if(haystack[i+j] != needle[j]) {
                    break;
                }
            }
            if(j == needle.length)
                return i;
        }

        return index;
    }

    public static void main(String args[]) {
        String needle = "oo";
        String haystack = "anoopdixith";
        int index = new SimpleSearch().find(needle, haystack);
        System.out.println("Index is " + index);
    }
}
