class Solution {
    Map<Integer, Integer> memo;
    public int numDecodings(String s) {
        memo = new HashMap<>();
        return recursion(0, s);
    }
    
    private int recursion(int index, String s){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        //Necessary to check conditions in this order
        //because, 1st condition OO bounds error
        //2nd elimates "0"
        //3rd, is the correct condition
        
        if(index == s.length()){
            return 1;
        }
        
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(index == s.length() -1){
            return 1;
        }
        
        int ans = recursion(index+1, s);
        if(Integer.parseInt(s.substring(index, index+2)) <= 26){
            ans+= recursion(index+2, s);
        }
        memo.put(index, ans);
        return ans;
    }
}