class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        long x = (long) n;
        //Otherwise
        //n%2 ==0, n/=2
        
        return (x & (-x)) == x;
    }
}