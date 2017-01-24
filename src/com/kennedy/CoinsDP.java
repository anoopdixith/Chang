package com.kennedy;

/**
 * Created by adixith on 12/18/16.
 */
public class CoinsDP {
    public static void main(String args[]) {
        int[] denominations = {2};
        int amount = 3;
        int minimumNumberOfCoins = new CoinsDP().findMinimumNumberOfCoinsDP(denominations, amount);
        System.out.println(minimumNumberOfCoins);
    }

    private int findMinimumNumberOfCoinsDP(int[] denominations, int amount) {
        int minimumNumberOfCoins = -1;
        return minimumNumberOfCoins;
    }


}
