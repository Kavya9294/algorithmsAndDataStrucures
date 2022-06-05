class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(memo, -1);
        int l1 = helper(nums,0,0);
        int l2 = helper(nums,1,0);
        return Math.max(l1,l2);
    }
    
    private int helper(int[] nums, int i, int sum){
        if(i >= nums.length){
            return sum;
        }
        if(this.memo[i] > -1){
            return this.memo[i];
        }
        sum = Math.max(sum + nums[i] + helper(nums, i+2,sum) , sum + helper(nums, i+1,sum));
        this.memo[i] = sum;
        return sum;
    }
}