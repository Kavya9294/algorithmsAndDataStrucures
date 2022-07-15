class Solution {
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i=0;i< grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, DFS(1,grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int DFS(int area, int[][] grid, int i, int j){

        grid[i][j]=0;
        for( int k = 0; k< directions.length; k++){
            int newRow = i+directions[k][0];
            int newCol = j+directions[k][1];
            if(newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0 && grid[newRow][newCol] == 1){
                area = DFS(area+1, grid, newRow, newCol);
            } 
        }
        return area;
    }
    
}