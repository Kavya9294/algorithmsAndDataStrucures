class Solution {
    public int calculate(String s) {    
        s = s + "+0";
        int length = s.length();
        int  currentNumber = 0, lastNumber = 0, result = 0;
        
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        
        char operation = '+';
        
        for(int i = 0; i < length; i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber*10) + (currentChar - '0');
            }
            if(!Character.isDigit(currentChar) || i == length -1){
                if(currentChar == '('){
                    numStack.offerLast(result);
                    numStack.offerLast(lastNumber);
                    opStack.offerLast(operation);
                    result = 0;
                    lastNumber = 0;
                    currentNumber = 0;
                    operation = '+'; 
                }else{
                    if(operation == '+' || operation == '-'){
                        result += lastNumber;
                        lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                    } else if ( operation == '*' ){
                        lastNumber = lastNumber * currentNumber;
                    } else if ( operation == '/' ){
                        lastNumber = lastNumber/currentNumber;
                    }
                    
                    if(currentChar == ')'){
                        currentNumber = result+lastNumber;
                        operation = opStack.pollLast();
                        lastNumber = numStack.pollLast();
                        result = numStack.pollLast();
                    }else{
                        operation = currentChar;
                        currentNumber = 0;
                    }
                }
            }
        }
                
        return result;
    }
}