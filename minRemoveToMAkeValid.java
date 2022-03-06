class Solution {
    Deque<Integer> stack = new ArrayDeque();
    List<Integer> indexesToRemove = new ArrayList<>();
    public String minRemoveToMakeValid(String s) {
        
        StringBuffer res = new StringBuffer();

        for(int i=0;i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else if (ch==')'){
                if(stack.size()>0){
                    stack.pop();
                }else{
                    indexesToRemove.add(i);
                }
            }
        }
        
        while(!stack.isEmpty())
            indexesToRemove.add(stack.pop());
        
        for(int i=0;i< s.length(); i++){
            if(!indexesToRemove.contains(i)){
                res.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}