package com.kennedy;

/**
 * Created by adixith on 1/2/17.
 */
public class WildCardMatching {
    public static void main(String[] args) {
        String string = "";
        String match = "a";
        Boolean isMatch = new WildCardMatching().isMatch(match, string);
        System.out.println(isMatch);
    }

    /*
    ? matches any single character
    * matches all characters
     */
    public Boolean isMatch(String match, String string) {
        Boolean isMatch = false;
        char[] bigString = string.toCharArray();
        char[] matchString = match.toCharArray();
        for(int i=0; i < bigString.length; i++) {
        }
        return isMatch;
    }
}
