class Solution {
    LPair[][] dp;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        dp = new LPair[n][n];
        return helper(arr, 0, n-1).sum;
    }
    
    public LPair helper(int[] arr, int l, int r){
        
        if(l>r){
            return new LPair(0, 1000000);
        }
        if(l == r){
            return new LPair(arr[l],0);
        }
        
        if(dp[l][r] !=null){
            return dp[l][r];
        }
        LPair ans = new LPair(0, 1000000);
        for(int i=l;i<r;i++){
            LPair lPair = helper(arr, l, i);
            LPair rPair = helper(arr,i+1,r);
            int total = lPair.sum+rPair.sum+(lPair.max*rPair.max);
            if(total < ans.sum){
                ans.max = Math.max(lPair.max, rPair.max);
                ans.sum = total;
            }
        }
        dp[l][r] = ans;
        return ans;
        
    }
    
    class LPair{
        int max;
        int sum;
        LPair(int max, int sum){
            this.max = max;
            this.sum = sum;
        }
    }
}