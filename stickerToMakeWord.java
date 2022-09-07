class Solution {
    int[][] lettersInWord;
    Map<String, Integer> memo;
    public int minStickers(String[] words, String target) {
        if(target == null || words == null)
            return -1;
        if(target.length() == 0 || words.length ==0)
            return 0;
        memo = new HashMap<>();
        memo.put("",0);
        lettersInWord = new int[words.length][26];
        
        for(int i= 0; i < words.length;i++){
            lettersInWord[i] = countLetters(words[i]);
        }
        
        return dfs(target);
        
    }
    
    private int[] countLetters(String word){
        int[] res = new int[26];
        for(char ch: word.toCharArray()){
            res[ch - 'a']++;
        }
        return res;
    }
    
    private int dfs(String target){
        if(memo.containsKey(target))
            return memo.get(target);
        
        int res = Integer.MAX_VALUE;
        int[] targetLetters = countLetters(target);
        
        for(int[] word : lettersInWord){
            //Check if word at least contains first letter in target
            if(word[target.charAt(0) - 'a']<=0){
                continue;
            }
            StringBuffer remainderWord = new StringBuffer();
            for(int i = 0; i < 26; i++){
                if(targetLetters[i] >0){
                    for(int times = 0; times < Math.max(targetLetters[i]-word[i], 0); times++){
                        remainderWord.append((char)('a'+i));
                    }
                }
            }
            
            int cur = dfs(remainderWord.toString());
            if(cur != -1){
                res = Math.min(res, cur);
            }
            
        }
        //1+res as we are using the current word
        res = res == Integer.MAX_VALUE ? -1 : 1+res;
        memo.put(target,res);
        return res;
    }
    
    
}