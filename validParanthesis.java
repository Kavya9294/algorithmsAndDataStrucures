class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> openBrackets = new HashSet<>(Arrays.asList('(', '[', '{'));
        for(char ch : s.toCharArray()){
            if(openBrackets.contains(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                switch(ch){
                        case ')' : if(stack.peek() == '(')
                        stack.pop();
                        else
                            return false;
                        break;
                        
                        case ']' : if(stack.peek() == '[')
                        stack.pop();
                        else
                            return false;
                        break;
                        
                        case '}' : if(stack.peek() == '{')
                        stack.pop();
                        else
                            return false;
                        break;
                        
                    default: break;
                }
            }
        }
        return stack.isEmpty();
    }
}