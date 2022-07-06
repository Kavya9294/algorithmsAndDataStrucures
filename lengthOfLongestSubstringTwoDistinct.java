class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 1 )
            return 1;
        int start = 0, end = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            while(end < s.length() && map.containsKey(s.charAt(end))){
                int ctr = map.get(s.charAt(end));
                map.put(s.charAt(end), ctr+1);
                end++;
            }
            if(map.size() == 2){
                int len = end - start;
                if(len > maxLen){
                    maxLen = len;
                }
            }
            
            if(end < s.length() && !map.containsKey(s.charAt(end))){
                while(map.size()==2){
                    int ctr = map.get(s.charAt(start));
                    if(ctr-1 == 0)
                        map.remove(s.charAt(start));
                    else
                        map.put(s.charAt(start), ctr-1);
                    start++;
                }
                map.put(s.charAt(end), 1);
                end++;
            }
            
            // if(map.size() == 2){
            //     int len = end - start;
            //     if(len > maxLen){
            //         maxLen = len;
            //     }
            // }
        }
        if(maxLen == 0){
            return s.length();
        }
        return maxLen;
    }
}