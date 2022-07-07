class Solution {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        Character[] digits = new Character[]{time.charAt(0),time.charAt(1), time.charAt(3), time.charAt(4)};
        TreeSet<Character> set = new TreeSet<Character>(Arrays.asList(digits));
        
        res[4] = format(set, digits[3], '9');
        if(res[4] > digits[3]) return new String(res);
        
        res[3] = format(set, digits[2], '5');
        if(res[3] > digits[2]) return new String(res);
        
        res[1] = res[0] == '2' ? format(set, digits[1], '3') : format(set, digits[1], '9');
        if(res[1] > digits[1]) return new String(res);
        
        res[0] = format(set, digits[0], '2');
        return new String(res);
        
    }
    
    private char format(TreeSet<Character> set, char digit, char limit){
        Character n = set.higher(digit);
        return (n == null || n > limit ? set.first() : n);
    }
}