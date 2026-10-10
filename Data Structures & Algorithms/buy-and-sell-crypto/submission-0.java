class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 1) return 0;
        int minValue = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < length; i++){
            maxProfit = Math.max(maxProfit, (prices[i] - minValue));
            minValue = Math.min(prices[i], minValue);
        }
        return maxProfit;
    }
}
