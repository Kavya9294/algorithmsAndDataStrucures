class Solution {
    int maxDist = 0, m = 0, n = 0;

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int [][] memo = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0;i<n; i++){
            for(int j =0; j< m ; j++){
                maxDist = Math.max(maxDist,DFS(i,j,matrix,1, memo, visited, directions));
            }
        }
        return maxDist;
    }
    
    private int DFS(int i, int j, int[][] matrix, int dist, int[][] memo, boolean[][] visited, int[][] directions){

        if(memo[i][j]!=0)
            return memo[i][j];
        visited[i][j] = true;
        int tempMaxDist = dist;
        for(int x=0;x<directions.length;x++){
            int newI = directions[x][0] + i;
            int newJ = directions[x][1] + j;
            if(newI>=n || newI<0 || newJ<0 || newJ >=m || visited[newI][newJ]){
                continue;
            }else if( matrix[newI][newJ] > matrix[i][j]){
                int tempDist = 1+DFS(newI, newJ, matrix, dist, memo, visited, directions);
                tempMaxDist = Math.max(tempMaxDist,tempDist);
            }
        }
        memo[i][j] = tempMaxDist;
        visited[i][j] = false;
        return tempMaxDist;
    }
}