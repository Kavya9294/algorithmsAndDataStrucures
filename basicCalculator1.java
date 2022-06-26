class Solution {
    public int calculate(String s) {
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                operand = 10*operand +(int) (ch - '0');
            }else if(ch == '+'){
                result += sign*operand;
                sign = 1;
                operand = 0;
            }else if (ch == '-'){
                result += sign*operand;
                sign = -1;
                operand = 0;
            }else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if ( ch == ')'){
                result += operand*sign;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
            
        }
        return result + (operand*sign);
    }
}