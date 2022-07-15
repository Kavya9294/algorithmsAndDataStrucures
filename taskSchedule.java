class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(char ch: tasks){
            frequencies[ch-'A']++;
        }
        Arrays.sort(frequencies);
        
        int max_time = frequencies[25];
        int idle_time = (max_time - 1) * n;
        
        for( int i = 24; i >= 0; i-- ){
            idle_time -= Math.min(max_time-1, frequencies[i]);
        }
        idle_time = Math.max(idle_time,0);
        return idle_time + tasks.length;
    }
}