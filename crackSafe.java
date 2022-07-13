class Solution {
    public String crackSafe(int n, int k) {
        //You will find the solution in targetLength steps
        int targetLength = (int) Math.pow(k,n);
        //Stating with 0000 for n = 4
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);
        
        Set<String> visited = new HashSet<>();
        visited.add(strPwd);
        //Doing a DFS on 0000 till TargetLength steps
        DFS(sbPwd, visited, targetLength, n, k);
        
        return sbPwd.toString();
    }
    
    private boolean DFS(StringBuilder sb, Set<String> visited, int targetLength, int n, int k){
        if(visited.size() == targetLength){
            return true;
        }
        
        String lastDigits = sb.substring(sb.length()-n+1);
        for(char ch = '0'; ch < '0'+ k; ch++){
            String newCombo = lastDigits + ch;
            if(!visited.contains(newCombo)){
                visited.add(newCombo);
                sb.append(ch);
                if(DFS(sb,visited, targetLength, n, k)){
                    return true;
                }
                visited.remove(newCombo);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}