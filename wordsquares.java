class Solution {
    List<List<String>> finalRes = new ArrayList<>();
    int lenOfRes=0;
    String[] words;
    Map<String,List<String>> memo = new HashMap<>();
    
    public List<List<String>> wordSquares(String[] words) {
        this.words=words;
        String prefix="";
        List<String> localRes = new ArrayList<>();

        for(String word: words){
            recurHelper(prefix,word,localRes);  
            localRes=new ArrayList<>();
            prefix="";
            }
            
        return finalRes;
        }
        

    public void recurHelper(String prefix, String word, List<String> localRes){
        
        
        if(prefix=="" || word.startsWith(prefix)){
            // memo.get(prefix)==null? memo.get(prefix).add(new ArrayList<>()): memo.get(prefix).add(word);
            localRes.add(word);    
            if(localRes.size()==word.length()){
                List<String> newArr = new ArrayList<>();
                newArr.addAll(localRes);
                finalRes.add(newArr);
                localRes.remove(localRes.size()-1);
                return;
            }
            
            prefix="";
            lenOfRes=localRes.size();
            for(String lWord: localRes){
                prefix += lenOfRes+1 >=lWord.length()?lWord.substring(lenOfRes):lWord.substring(lenOfRes, lenOfRes+1);
            }
            
            
            for(String chooseWord: this.words){
                if(chooseWord.startsWith(prefix))
                    recurHelper(prefix,chooseWord,localRes);
            }
            localRes.remove(localRes.size()-1);
        }else{
            return;
        }
    }
}