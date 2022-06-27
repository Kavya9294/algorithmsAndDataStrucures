class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0,0,result,new StringBuilder(),n);
        return result;
    }
    
    void backtrack(int open, int close, List<String> result,StringBuilder sb, int max){
        if(sb.length()==max*2){
            result.add(sb.toString());
            return;
        }
        
        if(open<max){
            sb.append("(");
            backtrack(open+1,close,result,sb,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backtrack(open,close+1,result,sb,max);
            sb.deleteCharAt(sb.length()-1);
        
        }
    }
}