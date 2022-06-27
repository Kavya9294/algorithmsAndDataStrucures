class Solution {
        
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer,Integer> order = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int ctr = order.getOrDefault(nums[i],0);
            order.put(nums[i],ctr+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                 (a,b) -> a.getValue()-b.getValue()
        );
        
        
        for(Map.Entry<Integer, Integer> entry: order.entrySet()){
            queue.offer(entry);
            if(queue.size()>k)
                queue.poll();
        }
        int ctr=0;
        while(!queue.isEmpty()){
            res[ctr++]=queue.poll().getKey();
        }
        
        return res;
    }
}