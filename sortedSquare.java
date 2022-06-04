class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0;i<nums.length;i++){
            pq.add(nums[i]*nums[i]);
        }
        
        int[] result = new int[nums.length];
        
        for(int i =0;i<nums.length;i++){
            result[i] = pq.poll();
        }
        
        return result;
    }
}