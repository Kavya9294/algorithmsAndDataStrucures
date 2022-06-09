/*
starts with the word
call helper with rest of the word
result.append(value from helper)
optinal space is with checking "" or " "
*/

class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo){
        List<String> result = new ArrayList<>();
        
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        
        if(s.length() == 0){
            result.add("");
            return result;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                String sub = s.substring(word.length());
                List<String> subs = wordBreakHelper(sub, wordDict, memo);
                
                for(String substr: subs){
                    String optionalSpace = substr.isEmpty()? "" : " ";
                    result.add(word+optionalSpace+substr);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}