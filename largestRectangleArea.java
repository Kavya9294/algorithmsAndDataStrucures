class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        int n = heights.length;
        //i-stack.peek()-1 is giving the upto which lke
        //9-7-1, corresponds to 8th element
        //if 8th element is heighest, then only width=1
        //if there's 7, 8 at i 7, 8,
        //for 7, we have, from 7 to 8, so, width = 2
        //i-stack.peek()-1 is measuing up until this index
        for(int i=0; i<n;i++){
            while(stack.peek()!=-1 && heights[stack.peek()] >= heights[i]){
                int t = stack.pop();
                int temp = heights[t];
                maxArea = Math.max(maxArea, (temp*(i-stack.peek()-1)));
            }
            stack.push(i);
        }
        
        while(stack.peek()!=-1){
            int t = stack.pop();
            int temp = heights[t];
            maxArea = Math.max(maxArea, (temp*(n-stack.peek()-1)));
        }
        
        return maxArea;
    }
}