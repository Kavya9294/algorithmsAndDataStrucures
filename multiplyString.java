class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        StringBuilder number1 = new StringBuilder(num1);
        StringBuilder number2 = new StringBuilder(num2);
        
        number1.reverse();
        number2.reverse();
        
        int N = number1.length() + number2.length();
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<N;i++){
            ans.append(0);
        }
        
        for(int place2 = 0; place2 < number2.length();place2++){
            int digit2 = number2.charAt(place2)-'0';
            
            for(int place1 = 0; place1 < number1.length();place1++){
                int digit1 = number1.charAt(place1) - '0';
                int currentPos = place1 + place2;
                
                int carry = ans.charAt(currentPos) -'0';
                int mul = digit1 * digit2 + carry;
                
                ans.setCharAt(currentPos, (char) (mul % 10 + '0'));
                int val = (ans.charAt(currentPos + 1) -'0') + mul/10;
                ans.setCharAt(currentPos+1, (char)(val+'0'));
            }
        }
        
        if(ans.charAt(ans.length()-1) == '0'){
            ans.deleteCharAt(ans.length()-1);
        }
        ans.reverse();
        return ans.toString();
    }
}