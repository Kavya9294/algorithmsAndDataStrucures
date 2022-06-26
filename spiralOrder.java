class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];
        
        int r = 0, c = 0, di = 0;
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};
        
        for( int i=0; i< R*C;i++){
            visited[r][c] = true;
            spiral.add(matrix[r][c]);
            int cr = r+dr[di];
            int cc = c+dc[di];
            if(cr>=0 && cr < R && cc >=0 && cc< C && !visited[cr][cc]){
                r = cr;
                c = cc;
            }else{
                di = (di+1)%4;
                r = r+dr[di];
                c = c+dc[di];
            }
        }
        return spiral;
    }
    
}