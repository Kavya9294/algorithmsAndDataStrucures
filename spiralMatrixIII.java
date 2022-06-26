/*
1, 1, 2, 2, 3, 3, 4, 4, ... That is, we walk 1 unit east, then 1 unit south, then 2 units west, then 2 units north, then 3 units east, etc.
*/

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        
        int[][] ans = new int[R*C][2];
        int t = 0;
        ans[t++] = new int[]{r0,c0};
        if(R*C == 1) return ans;
        
        for(int k = 1; k < 2*(R*C); k+=2){
            for(int i=0; i < 4; i++){
                int dk = k + (i/2);
                for(int j = 0; j < dk; j++){
                    r0 += dr[i];
                    c0 += dc[i];
                    if(r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
                        ans[t++] = new int[]{r0,c0};
                        if(t == R*C)
                            return ans;
                    }
                }
            }
        }
        throw null; 
    }
}