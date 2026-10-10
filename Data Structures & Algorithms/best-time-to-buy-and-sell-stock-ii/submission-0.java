class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0) return 0;
        int minStockValue = prices[0];
        int max = 0;

        for(int i = 1; i < length; i++){
            if(prices[i] < minStockValue){
                minStockValue = prices[i];
            }
            else {
                max += prices[i] - minStockValue;
                minStockValue = prices[i];
            }
        }
        return max;
    }
}