class Solution {
    public boolean canJump(int[] nums) {
        int maxPosition = nums.length-1;
        
        for(int i = maxPosition-1;i>=0;i--){
            if(nums[i]+i >= maxPosition)
                maxPosition = i;
        }
        
        return maxPosition == 0;
    }
}