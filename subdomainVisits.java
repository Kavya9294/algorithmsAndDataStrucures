class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<>();
        for(String domain: cpdomains){
            String[] cp = domain.split(" ");
            int cnt = Integer.parseInt(cp[0]);
            cp = cp[1].split("\\.");
            StringBuffer tt = new StringBuffer();
            for(int i = cp.length-1; i>=0;i--){
                String sub = cp[i];
                
                if(tt.length() == 0){
                    tt.append(sub);
                }else{
                    tt.insert(0,sub+".");
                }
                int temp = count.getOrDefault(tt.toString(), 0) + cnt;
                count.put(tt.toString(), temp);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry: count.entrySet()){
            result.add(String.valueOf(entry.getValue())+" "+entry.getKey());
        }
        return result;
    }
}