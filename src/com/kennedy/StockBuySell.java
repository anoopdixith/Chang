package com.kennedy;

/**
 * Created by adixith on 12/28/16.
 */
public class StockBuySell {
    public static void main(String args[]) {
        int[] stockPrices1 = new int[]{1,2,1,5,6,7,3,4,1,4,9,11,3,4};
        int[] stockPrices = new int[]{7,5,3,8,1};
        int[] buySellIndex = new StockBuySell().getButSellIndex(stockPrices);
        //new StockBuySell().getProfti(stockPrices);
        int maxProfit = new StockBuySell().maxProfit(stockPrices1);
        System.out.println("Max profit is " + maxProfit);
    }

    public int[] getButSellIndex(int[] stockPrices) {
        int indices[] = new int[2];
        int minIndex = 0;
        int maxDiff = stockPrices[0];
        for(int i = 1; i < stockPrices.length; i++) {
           ;
        }
        return indices;
    }

    public int maxProfit(int[] stockPrices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        int runningMinIndex = -1;
        for(int i=0; i < stockPrices.length; i++) {
            //maxProfit = Math.max(maxProfit,  stockPrices[i] - minPrice);

            if(maxProfit < stockPrices[i] - minPrice) {
                maxProfit = stockPrices[i] - minPrice;
                maxIndex = i;
                minIndex = runningMinIndex;
            }

            if(stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
                runningMinIndex = i;
            }

            //minPrice = Math.min(minPrice, stockPrices[i]);
        }
        System.out.println("Buy index is " + minIndex + " at value " + stockPrices[minIndex]);
        System.out.println("Sell index is " + maxIndex + " at value " + stockPrices[maxIndex]);
        return maxProfit;
    }

    public void getProfti(int[] stockPrices) {
        int minIndex = 0;
        int maxDiff = stockPrices[0];
        int profit = 0;
        for(int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i] < stockPrices[i-1])
                minIndex = i;
            if(stockPrices[i-1] < stockPrices[i] &&
                    (i+1 == stockPrices.length || stockPrices[i] > stockPrices[i+1])) {
                profit += stockPrices[i] - stockPrices[i - 1];
                System.out.println("Buy on " + minIndex + " sell on " + i);
            }
        }
        System.out.println("Total Profit is " + profit);
    }
}
