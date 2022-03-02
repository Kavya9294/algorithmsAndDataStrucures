class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        int i=0;
        while(i<list.size()-1){
            int[] cur = list.get(i);
            int[] next = list.get(i+1);
            if(cur[1]<next[0]){
                i = i+1;
                continue;
            }
            if(cur[1] >= next[0] && cur[1] <= next[1]){
                int[] arr = new int[]{cur[0],next[1]};
                list.set(i, arr);
                list.remove(next);
            }else if(cur[1] >= next[1]){
                int[] arr = new int[]{cur[0],cur[1]};
                list.set(i, arr);
                list.remove(next);
            }
            
            
        }
        i = 0;
        int[][] res = new int[list.size()][2];
        for (int[] nestedList : list) {
            res[i++] = nestedList;
        }
        
        return res;
    }
}