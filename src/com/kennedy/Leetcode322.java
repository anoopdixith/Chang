package com.kennedy;

/**
 * Created by adixith on 12/18/16.
 */
public class Leetcode322 {
    public static void main(String args[]) {
        int[] denominations = {2};
        int amount = 3;
        int minimumNumberOfCoins = new Leetcode322().findMinimumNumberOfCoins(denominations, amount);
        System.out.println(minimumNumberOfCoins);
    }

    private int findMinimumNumberOfCoins(int[] denominations, int amount) {
        int minimumNumberOfCoins = 0;
        int denominationIndex = denominations.length -1;
        while(amount > 0) {
            minimumNumberOfCoins += amount /denominations[denominationIndex];
            amount %= denominations[denominationIndex];
            denominationIndex--;
            if(denominationIndex < 0 && amount > 0)
                return -1;
        }
        return minimumNumberOfCoins;
    }
}
