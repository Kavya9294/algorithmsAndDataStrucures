class Solution {
    public int numSubseq(int[] nums, int target) {
        int total = 0;
        int mod = (int)Math.pow(10,9)+7;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int[] power=new int[nums.length];  //Calculating the power in the power array.
        power[0]=1; // no. of subsequences formed using one no. is 1
        //Actuall algo does not reqiore the whole power array
        //Java changes only!
        //Can start fro while loop
        for(int idx=1;idx<nums.length;idx++)
            power[idx]=(power[idx-1]*2)%mod; 
        
        while(i<=j){
            if(nums[i]+nums[j] <= target){
                total= (total+power[j-i])%mod;
                i++;
            }else{
                j--;
            }
        }

        
        return total%mod;
    }
}