package com.kennedy;

/**
 * Created by adixith on 12/18/16.
 */
public class MinimumInsertionsToMakePalindrome {
    public static void main(String[] args)
    {
        String s = "baacab";
        System.out.println(new MinimumInsertionsToMakePalindrome().minInsertionsToPalindrom(s));
    }

    private int minInsertionsToPalindrom(String string) {
        char[] input = string.toCharArray();
        int length = input.length;
        int[][] minimumInsertionTable = new int[length+1][length+1];
        return -1;
    }
}
