class Solution {
    //Find lowest value
    //find profit with current lowest value and 
    // if you find lower, make that min, but, 
    //if profit was better with previous min
    // that remains. Only min will update.
    //Minimize value, maximize profit
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0;i< prices.length;i++){
            if(prices[i] < minPrice )
                minPrice = prices[i];
            else if(maxProfit < prices[i] - minPrice)
                maxProfit = prices[i] - minPrice;
        }
        
        return maxProfit;
    }
}