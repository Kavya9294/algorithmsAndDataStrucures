class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo =  new int[amount];
        int res = helper(coins, amount, 0, memo);
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    private int helper(int[] coins, int amount, int total, int[] memo){
        if(total!= 0 && total < amount && memo[total-1]!= 0 ){
            return memo[total-1];
        }
        if(total == amount){
            return 0;
        }
        if(total > amount){
            return Integer.MAX_VALUE;
        }
        int minSteps = Integer.MAX_VALUE;
        
        for(int j = 0;j< coins.length;j++){
            if(amount<coins[j])
                continue;
            int res=helper(coins, amount, coins[j]+total, memo);
            minSteps = Math.min(minSteps, res == Integer.MAX_VALUE? Integer.MAX_VALUE : 1+ res );
        }
        if(total != 0 && total < amount)
            memo[total-1]= minSteps;
                                
        return minSteps;
    }
}