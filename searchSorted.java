class Solution {
    public int search(int[] nums, int target) {
        
        int lo=0, hi = nums.length-1;
        int n = nums.length;
        //Break it into 2 scenarios
        //1) we are in the correct order(0-n/2): check for this area (lo<mid)
        //2) search in the greater area(n/2 to n): else has to be in greater region
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[lo] <= nums[mid] ){
                if(target >= nums[lo] && target < nums[mid]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{
                if(target <= nums[hi] && target > nums[mid]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            
        }
        return -1;
    }
}