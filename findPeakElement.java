/*
When nums[mid] > nums[mid+1]
we know that we already found element > next element
So, search to the right and when min < mid+1, mid+1 is the ans

*/

class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo+(hi-lo)/2;
            
            if(nums[mid] > nums[mid+1]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
}