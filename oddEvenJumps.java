/*
1st jump ( odd condition)
2nd jump( even condition)
only higher is checked because if you cant take the
first step, then its not possible
*/
class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int res = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] lower = new boolean[n];
        boolean[] higher = new boolean[n];
        map.put(arr[n-1],n-1);
        lower[n-1] = true;
        higher[n-1] = true;
        
        for(int i=n-2;i>=0;i--){
            Map.Entry higherVal = map.ceilingEntry(arr[i]);
            Map.Entry lowerVal = map.floorEntry(arr[i]);
            //Odd step
            if(higherVal!= null)
                higher[i] = lower[(int)higherVal.getValue()];
            //Even step
            if(lowerVal !=null)
                lower[i] = higher[(int)lowerVal.getValue()];
            map.put(arr[i],i);
            if(higher[i])
                res++;
        }
        
        return res;
    }
}