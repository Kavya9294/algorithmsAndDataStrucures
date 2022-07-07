class Solution {
    public int expressiveWords(String s, String[] words) {
        int counter = 0;
        
        for(String word : words){
            if(check(s,word)) counter++;
        }
        
        return counter;
    }
    
    private boolean check(String s, String word){
        if(s.equals(word)){
            return true;
        }
        
        if(s.length() == 0 || word.length() ==0 || word.length() > s.length()){
            return false;
        }
        int i=0,j=0;
        int sLen = s.length();
        int wLen = word.length();
        
        while(i < sLen && j < wLen){
            if(s.charAt(i) != word.charAt(j)){
                return false;
            }
            
            int prevS = i;
            while(i < sLen && s.charAt(i) == s.charAt(prevS)){
                i++;
            }
            
            int prevW = j;
            while( j< wLen && word.charAt(j) == word.charAt(prevW)){
                j++;
            }
            
            if( (i-prevS) < (j-prevW) || ((i - prevS) < 3 && (i-prevS) > (j- prevW)) ){
                return false;
            }
        }
        
        return (i == sLen && j == wLen);
    }
}