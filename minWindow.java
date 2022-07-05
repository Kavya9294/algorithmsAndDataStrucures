class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;

        int[] arr = new int[128];
        int counter = 0;
        int minLen = Integer.MAX_VALUE;
        
        char[] t_arr = t.toCharArray();
        char[] s_arr = s.toCharArray();
        
        String result = "";
        
        for(char c: t_arr){
            arr[c]++;
        }
        
        while(right < s.length()){
            char curChar = s_arr[right];
            if(--arr[curChar] >= 0){
                counter++;
            }
            while(counter == t_arr.length){
                char curLeft = s_arr[left];
                if(++arr[curLeft] > 0){
                    counter--;
                }
                
                int len = right-left+1;
                if(len < minLen){
                    minLen = len;
                    result = s.substring(left,right+1);
                }
                
                left++;
            }
            right++;
        }
        
        return result;
    }
}