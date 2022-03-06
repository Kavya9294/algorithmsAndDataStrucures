class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        for(int[] interval: intervals){
            if(minHeap.isEmpty()){
                minHeap.add(interval);
            }else if(interval[0] >= minHeap.peek()[1]){
                minHeap.remove();
                minHeap.add(interval);
            }else{
                minHeap.add(interval);
            }
        }
        
        return minHeap.size();
    }
}