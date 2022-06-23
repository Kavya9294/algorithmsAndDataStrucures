class Solution {
    //Shortest patch go for BFS
    private int[][] directions = new int[][] {{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1]!=0){
            return -1;
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if(row == grid.length - 1 && col == grid[0].length-1){
                return distance;
            }
            for(int[] neighbor : getNeighbors(row,col,grid)){
                int newRow = neighbor[0];
                int newCol = neighbor[1];
                queue.add(new int[]{newRow,newCol});
                grid[newRow][newCol]=distance+1;
            }
        }
        return -1;
    }
    
    private List<int[]> getNeighbors(int row, int col, int[][] grid){
        List<int[]> result = new ArrayList<>();
        for(int[] d: directions){
            int newRow = row+d[0];
            int newCol = col + d[1];
            if(newRow <0 || newRow>=grid.length || newCol<0 || newCol >= grid.length || grid[newRow][newCol]!=0)
                continue;
            result.add(new int[]{newRow,newCol});
        }
        return result;
    }
}