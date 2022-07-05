class Solution {
    public int[] plusOne(int[] digits) {        
        int sum = digits[digits.length-1]+1;
        int carry = sum/10;
        sum = sum%10;
        digits[digits.length-1] = sum;
        if(carry == 0){
            return digits;
        }
        
        int[] result = new int[digits.length+1];

        for(int i=digits.length-2;i>=0;i--){
            sum = digits[i]+carry;
            carry = sum/10;
            sum = sum%10;
            digits[i] = sum;
            if(carry == 0){
                break;
            }
        }
        
        if(carry > 0){
            result[0] = carry;
            for(int i=1;i<result.length;i++){
                result[i] = digits[i-1];
            }
        }else{
            return digits;
        }
        
        return result;
    }
}