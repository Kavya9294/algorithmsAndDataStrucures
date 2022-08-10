class Solution {
    public String reorganizeString(String s) {
        int[] letters = new int[26];
        int max = 0;
        int let=0;
        for(char ch : s.toCharArray()){
            letters[ch - 'a']++;
            if(letters[ch - 'a'] > max){
                max = letters[ch - 'a'];
                let = ch - 'a';
            }
        }
        
        if(max > (s.length()+1)/2){
            return "";
        }
        
        int idx=0;
        char[] arr = new char[s.length()];
        while(letters[let] >0){
            letters[let]--;
            arr[idx] = (char) ( let+'a');
            idx+=2;
        }
        letters[let] = 0;
        for( int i = 0; i<letters.length;i++){
            while(letters[i] > 0){
                if(idx >= s.length()){
                    idx = 1;
                }
                letters[i]--;
                arr[idx] = (char) (i+'a');
                idx+=2;
            }
        }
        return new String(arr);
    }
}