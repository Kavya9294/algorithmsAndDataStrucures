class Solution {
    Map<String,String> mapper = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        
        mapper.put("2","abc");
        mapper.put("3","def");
        mapper.put("4","ghi");
        mapper.put("5","jkl");
        mapper.put("6","mno");
        mapper.put("7","pqrs");
        mapper.put("8","tuv");
        mapper.put("9","wxyz");
        
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> ans = new ArrayList<>();
        backtrack(digits,ans,0,new StringBuilder());
        return ans;
    }
    
    
    public void backtrack(String digits, List<String> ans,int index, StringBuilder path){
        if(path.length()==digits.length()){
            ans.add(path.toString());
            return;
        }
        
        String possibleLetters =  mapper.get(String.valueOf(digits.charAt(index)));
        for(char letter: possibleLetters.toCharArray()){
            path.append(letter);
            backtrack(digits,ans,index+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}