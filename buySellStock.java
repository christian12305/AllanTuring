//Leetcode: 714. Best Time to Buy and Sell Stock with Transaction Fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0;
        int buyPrice = prices[0];
        
        for (int i = 1; i < n; i++) {
            profit = Math.max(prices[i] - buyPrice - fee, profit);
            buyPrice = Math.min(buyPrice, prices[i] - profit);
        }
        
        return profit;
    }
}