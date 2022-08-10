import java.util.*;
public class MyClass {
    public static void shiftingLetters(String s, int[] shifts) {
        Arrays.sort(shifts);
        int n = shifts.length;
        int total = 0;
        int last = shifts[n-1]%26;
        int[] arr = new int[last];
        for( int i= n-1; i >= 0 ; i--){
           arr[shifts[i]-1] +=1; 
           arr[shifts[i]-1] %=26;
        }
        for( int i= arr.length-2; i >= 0 ; i--){
            arr[i] += arr[i+1];
            arr[i] %= 26;
        }
        char[] chars = s.toCharArray();
        
        for( int i = 0; i < arr.length; i++){
            char ch = s.charAt(i);
            int temp = ((ch - 'a') + arr[i])%26;
            ch = 'a';
            ch += temp;
            chars[i] = ch;
        }
        
        System.out.println(String.valueOf(chars));
        
    }

    public static void main(String args[]) {
        int[] shifts = {1,2,3,4};
        String s = "abcd";
        shiftingLetters(s, shifts); 
        int[] shifts2 = {1,1,3};
        s = "aez";
        shiftingLetters(s, shifts2);
        int[] shifts3 = {2,2,2};
        s = "abc";
        shiftingLetters(s, shifts3);
    }
}