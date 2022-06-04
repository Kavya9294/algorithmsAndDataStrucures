class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int left_max = 0, right_max = 0;
        int capacity=0;
        
        while(l<r){
            if(height[l]<height[r]){
                if(left_max<height[l])
                    left_max = height[l];
                capacity+=left_max-height[l];
                l++;
            }else{
                if(right_max < height[r]){
                    right_max = height[r];
                }
                capacity+=right_max-height[r];
                r--;
            }
        }
        
        return capacity;
            
    }
}