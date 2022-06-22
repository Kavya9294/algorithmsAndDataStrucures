class Solution {
    
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderArr = new int[k];
        remainderArr[0] = 1;
        int sum =0, total = 0;
        
        for(int a: nums){
            sum = (sum+a) %k;
            //this is required because it'll go to negative index
            //This way, we get the positive index
            //in correct division, -2%5 = 3
            //java gives 0, hence the special handling
            if(sum < 0) sum+=k;
            total += remainderArr[sum];
            remainderArr[sum]++;
        }
        
        return total;
    }
    
}