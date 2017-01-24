package com.kennedy;

/**
 * Created by adixith on 12/18/16.
 */
public class LeastCommonSubsequence {
    public static void main(String args[]) {
        String string1 = "abcde";
        String string2 = "cdefgh";
        int lcsLength = new LeastCommonSubsequence().findLeastCommonSubsequenceLength(string1, string2, "bruteforce");
        int lcsLengthDp = new LeastCommonSubsequence().findLeastCommonSubsequenceLength(string1, string2, "dynamicprogramming");
        System.out.println(lcsLengthDp);
    }

    private int findLeastCommonSubsequenceLength(String string1, String string2, String algorithm) {
        int length = -1;
        switch (algorithm) {
            case "bruteforce":
                return findLeastCommonSubsequenceLengthBruteForce(string1.toCharArray(),string2.toCharArray(), string1.length()-1, string2.length()-1);
            case "dynamicprogramming":
                return findLeastCommonSubsequenceLengthDP(string1.toCharArray(),string2.toCharArray(), string1.length()-1, string2.length()-1);
        }
        return length;
    }

    private int findLeastCommonSubsequenceLengthBruteForce(char[] string1, char[] string2, int m, int n) {
        if(m == 0 || n==0) {
            return 0;
        }
        if (string1[m] == string2[n]) return 1 + findLeastCommonSubsequenceLengthBruteForce(string1, string2, m-1, n-1);
        return Math.max(findLeastCommonSubsequenceLengthBruteForce(string1, string2, m, n-1),
                    findLeastCommonSubsequenceLengthBruteForce(string1, string2, m-1, n));
    }

    private int findLeastCommonSubsequenceLengthDP(char[] string1, char[] string2, int m, int n) {
        int[][] lcsTable = new int[m+1][n+1];
        for(int i=0; i <= m; i++) {
            for(int j=0; j<= n; j++) {
                if(i == 0 || j ==0) {
                    lcsTable[i][0] = 0;
                }
                else if(string1[i] == string2[j]) {
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;
                }
                else {
                    lcsTable[i][j] = Math.max(lcsTable[i][j-1], lcsTable[i-1][j]);
                }
            }
        }
        int i=0, j = 0, k=0;
        char[] longestSubsequence = new char[lcsTable[m][n] + 1];
        while(i < string1.length && j < string2.length) {
            if(string1[i] == string2[j]) {
                longestSubsequence[k++] = string1[i];
                i++; j++;
            }
            else if(lcsTable[i+1][j] >= lcsTable[i][j+1]) {
                i++;
            }
            else
                j++;
        }
        System.out.println(longestSubsequence);
        return lcsTable[m][n];
    }
}
