package com.kennedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adixith on 12/10/16.
 */
public class LeetCode467 {
    public int findSubstringsInWraparoundString(String inp) {
        int total = 0;
        char[] input = inp.toCharArray();
        findAllSubstrings(input);
        for(String substring:allSubstrings) {
            if(substring.length() == 1){
                //System.out.println(subs);
                total++;
            }
            else {
                char[] subs = substring.toCharArray();
                for(int i=0; i<subs.length-1;i++) {

                    //System.out.print("Diff ");
                    //System.out.println((subs[i+1]-'a') - (subs[i]-'a'));
                    if(!((subs[i+1]-'a') - (subs[i]-'a') == 1 ||
                            (subs[i+1]-'a') - (subs[i]-'a') == -25))
                        break;
                    else {
                        if(i == subs.length-2) {
                            //System.out.println(subs);
                            total++;
                        }
                        else
                            continue;
                    }
                }
            }
        }
        return total;
    }

    Set<String> allSubstrings = new HashSet<>();
    private void findAllSubstrings(char[] input) {
        String word = new String(input);
        for (int from = 0; from < word.length(); from++) {
            for (int to = from + 1; to <= word.length(); to++) {
                allSubstrings.add(word.substring(from, to));
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(new LeetCode467().findSubstringsInWraparoundString("cac"));
    }

    public int findSubstringInWraproundString(String p) {
        if (p==null || p.isEmpty()) return 0;

        HashMap<Character, Integer> charMaxLen = new HashMap<>();
        charMaxLen.put(p.charAt(0), 1);
        int sum = 1;
        int len = 1;

        for (int i=1; i<p.length(); i++) {
            char prev = p.charAt(i-1);
            char cur = p.charAt(i);
            if (isSequential(prev, cur)) {
                len++;
            } else {
                len = 1;
            }

            //m+=Math.max(len-charMaxLen.getOrDefault(cur,0), 0);
            //charMaxLen.putIfAbsent(cur, 0);
            charMaxLen.put(cur, Math.max(len, charMaxLen.get(cur)));
        }
        return sum;
    }

    private boolean isSequential(char prev, char cur) {
        return (prev=='z' && cur=='a') || (cur-prev==1);
    }
}
