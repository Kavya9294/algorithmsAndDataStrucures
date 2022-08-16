class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{0,0};

        int first = getBound(nums, target, true);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = getBound(nums, target, false);
        result[0] = first;
        result[1] = last;
        return result;
    }
    
    private int getBound(int[] nums, int target, boolean isFirst){
        int lo = 0, hi = nums.length-1;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == lo || nums[mid-1] != target){
                        return mid;
                    }
                    hi = mid-1;
                }else{
                    if(mid == hi || nums[mid+1]!=target){
                        return mid;
                    }
                    lo = mid+1;
                }
            }else if( nums[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }
}