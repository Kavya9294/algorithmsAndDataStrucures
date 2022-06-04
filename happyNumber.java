class Solution {

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = computeSum(n);
        
        while(fastRunner!=1 && slowRunner!=fastRunner){
            slowRunner = computeSum(slowRunner);
            fastRunner = computeSum(computeSum(fastRunner));
        }
        
        return fastRunner==1;
        
    }
    
    public int computeSum(int n){
        int sum = 0;
        while(n!=0){
            int p = n%10;
            sum+=p*p;
            n=n/10;
        }
        return sum;
    }
    
}