class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest=1;
        int assumed=1;
        if(s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for(int i=0,j=1;i<s.length() && j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                //j-i: distance between new and old dupe
                longest = Math.max(longest,Math.max(assumed,j-i));
                //Move start to the latest dupe
                i=Math.max(map.get(s.charAt(j))+1,i);
                map.put(s.charAt(j),j);
                //Consider from the 1st dupe
                //and add the current char 
                assumed=j-i+1;
            }else{
                map.put(s.charAt(j),j);
                assumed++;
            }
        }
        //Need to add this step for when it does not 
        //encounter duplicate at all
        longest = Math.max(longest,assumed);
        return longest;
    }
}