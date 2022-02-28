class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int maxArea=0;
        if(height.length<2){
            return 0;
        }
        
        while(right>left){
            maxArea = Math.max(maxArea, (Math.min(height[left],height[right])*(right-left)));
            if(height[right]>height[left])
                left++;
            else
                right--;
        }
        
        return maxArea;
        
    }
}