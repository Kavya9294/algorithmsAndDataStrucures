class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo =  new int[amount];
        int res = helper(coins, amount, memo);
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    private int helper(int[] coins, int remain, int[] memo){
        if(remain < 0){
            return Integer.MAX_VALUE;
        }
        if(remain == 0){
            return 0;
        }
        if(memo[remain-1] > 0){
            return memo[remain-1];
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int tmp = helper(coins, remain-coins[i],memo);
            if(tmp != Integer.MAX_VALUE)
                res = Math.min(res, 1+tmp);
        }
        
        memo[remain-1] =  res;
        return res;
    }
}