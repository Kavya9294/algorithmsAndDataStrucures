/*
For StringBuffer use
(sb.length()+1) % (k+1) == 0 ? "-":"";
*/
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        Deque<String> q = new ArrayDeque<>();
        int n = s.length();
        int i;
        
        for(i=n;i>=0;i-=k){
            if((i-k < 0)) break;
            q.push(s.substring(i-k,i).toUpperCase());
            if(i-k>0)
                q.push("-");
        }
        if(i>0){
            q.push(s.substring(0,i).toUpperCase());
        }
        String p="";
        while(!q.isEmpty()){
            p += q.pop();
        }
        return p;
    }
}