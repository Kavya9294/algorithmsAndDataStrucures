class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> res = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer(expression);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.indexOf("{") == -1){
                res.add(cur);
                continue;
            }
            int left = cur.indexOf("{");
            int index = 0;
            while(index < cur.length() && cur.charAt(index) != '}'){
                if(cur.charAt(index) == '{'){
                    left = index;
                }
                index ++;
            }
            
            int right = index;
            
            String processed = cur.substring(0, left);
            String[] processing = cur.substring(left+1, right).split(",");
            String unprocessed = cur.substring(right+1);
            
            for(String part:processing){
                StringBuilder sb = new StringBuilder(processed);
                sb.append(part).append(unprocessed);
                q.offer(sb.toString());
            }
            
        }
        
        List<String> resList = new ArrayList<>(res);
        Collections.sort(resList);
        return resList;
    }
}