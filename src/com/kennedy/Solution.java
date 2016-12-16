package com.kennedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adixith on 10/30/16.
 */
public class Solution {
    public int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        int start = 1;
        while(n > length * count) {
            n -= length*count;
            length++;
            count*=10;
            start*=10;
        }
        start+= (n-1)/length;
        String s= Integer.toString(start);
        return Character.getNumericValue(s.charAt((n-1)%length));
    }

    public static void main(String a[]) {
        //System.out.println(new Solution().findNthDigit(60));
        System.out.println(new Solution().longestSubstring("cababb", 3));
    }

    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;

    }

    public Solution(){}

    public int pick(int target) {
        List<Integer> allIndices = new ArrayList<Integer>();
        for(int i =0; i < nums.length; i++) {
            if(nums[i]==target) {
                allIndices.add(i);
            }
        }
        int max = allIndices.size();
        return allIndices.get(new java.util.Random().nextInt(max));
    }

    /*
    cababbd with k = 3 => ababb => 5 chars
     */
    public int longestSubstring(String s, int k) {
        System.out.println("Checking in " + s);
        int arr[] = new int[26];
        for(char c:s.toCharArray()) {
            arr[c - 'a']++;
        }
        int index =0;
        int max =0;
        for(int i=0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(index,i),k));
                index++;
            }
        }
        return index == 0?s.length(): Math.max(max, longestSubstring(s.substring(index),k));
    }
}
