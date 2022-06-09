class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
      /*
      https://www.youtube.com/watch?v=DfljaUwZsOk&ab_channel=NeetCode
      Store value in decending order in q
      remove from right if lesser
      add to right
      start > first value, remove from left
      max value is at left(first)
      [1,1,1,1,1,4,5], k = 6
      */
        
        if(k == 1) return nums;
        int size = k;
        int[] result = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        
        int start = 0, end = 0;
        
        while(end < nums.length){
            
            while( !q.isEmpty() && nums[q.peekLast()] < nums[end])
              q.pollLast();
          q.add(end);
          
          if(start > q.peekFirst())
            q.pollFirst();
          
          if(end+1 >= k){
            result[start] = nums[q.peekFirst()];
            start++;
          }
          end++;
           
        }

        
        return result;
    }
}