class Solution {
    public String originalDigits(String s) {
        int[] arr = new int[10];
        
        for(char ch:s.toCharArray()){
            if(ch=='z') arr[0]++;
            if(ch=='w') arr[2]++;
            if(ch=='u') arr[4]++;
            if(ch=='x') arr[6]++;
            if(ch=='g') arr[8]++;
            if(ch=='o') arr[1]++;
            if(ch=='h') arr[3]++;
            if(ch=='f') arr[5]++;
            if(ch=='s') arr[7]++;
            if(ch=='i') arr[9]++;            
        }
        
        arr[1]-=(arr[0]+arr[2]+arr[4]);
        arr[3]-=arr[8];
        arr[5]-=arr[4];
        arr[7]-=arr[6];
        arr[9]-=(arr[6]+arr[8]+arr[5]);
        
        String str = "";
        for(int i=0;i<10;i++){
            str+=String.valueOf(i).repeat(arr[i]);
        }
        
        return str;

    }
}