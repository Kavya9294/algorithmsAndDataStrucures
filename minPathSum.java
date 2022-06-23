class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return helper(grid, 0,0,Integer.MAX_VALUE, memo);
    }
    
    private int helper(int[][] grid, int i, int j,int sum, int[][] memo){
        if (i == grid.length || j == grid[0].length) 
            return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if( memo[i][j] != 0){
            return memo[i][j];
        }
        
        sum = grid[i][j] + Math.min(helper(grid, i+1, j,sum, memo), helper(grid, i, j+1,sum, memo) );
        
        
        memo[i][j] = sum;
        return sum;
    }
}