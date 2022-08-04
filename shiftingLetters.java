class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] chars = s.toCharArray();
        int total;
        int fin = shifts[n-1]%26;
        total = ((s.charAt(n-1) -'a')+(fin))%26;
        char last ='a';
        last += total;
        chars[n-1] = last;

        for(int i = shifts.length-2; i >=0; i--){
            char ch = 'a';
            fin = (shifts[i]+fin)%26;
            total =((s.charAt(i)-'a') + (fin))%26;
            ch += total;
            chars[i] = ch;
        }
        return String.valueOf(chars);
    }
}