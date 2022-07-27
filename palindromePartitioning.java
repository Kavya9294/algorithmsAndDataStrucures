class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(result, s, new ArrayList<>(),0);
        return result;
    }
    
    private void backTrack(List<List<String>> result, String s, List<String> tempList, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i=start;i<s.length();i++){
            if(isPalindrome(start, i, s)){
                tempList.add(s.substring(start, i+1));
                backTrack(result,s, tempList, i+1);
                tempList.remove(tempList.size()-1);
            } 
        }
        
    }
    private boolean isPalindrome(int low, int high, String s){
        while(low<high){
            if(s.charAt(low++)!=s.charAt(high--))
                return false;
        }
        return true;
    }
}