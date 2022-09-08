class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        char[] chArr = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++, j++){
            chArr[j] = chArr[i];
            if(j == 0 || chArr[j] != chArr[j-1]){
                stack.push(1);
            }else{
                int inc = stack.pop()+1;
                if(inc == k){
                    j = j-k;
                }else{
                    stack.push(inc);
                }
            }
        }
        
        return new String(chArr, 0, j);
    }
}