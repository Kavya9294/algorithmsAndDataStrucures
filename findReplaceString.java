class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuffer result = new StringBuffer(s);
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        
        for(int i=0;i< indices.length;i++){
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }
        
        Arrays.sort(indices);
        /* Start from last so that
        you never overrite on a character 
        that was previously replaced
        */
        for(int i=indices.length-1;i>=0;i++){
            int idx = indices[i];
            String source = sourceMap.get(indices[i]);
            String target = targetMap.get(indices[i]);
            String compare = s.substring(idx, idx+source.length());
            int compareLength = idx+source.length();
            if(compare.equals(source)){
                result.replace(idx, compareLength, target);
            }
        }
        
        return result.toString();
    }
}