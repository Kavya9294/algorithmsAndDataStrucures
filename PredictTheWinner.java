class Solution {
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
       return winner(nums, 0,nums.length-1,memo) >= 0;
        
    }
    
   private  int winner(int[] nums, int lo, int hi,Integer[][] memo){
        if(lo == hi){
            return nums[lo];
        }
        if(memo[lo][hi]!=null){
           return memo[lo][hi];
        }
        int a = nums[lo] - winner(nums, lo+1, hi, memo);
        int b = nums[hi] - winner(nums, lo, hi-1, memo);
        
        memo[lo][hi] = Math.max(a,b);
        return memo[lo][hi];
    }
}