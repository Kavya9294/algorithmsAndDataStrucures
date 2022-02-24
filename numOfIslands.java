class Solution {
    Boolean[][] visited;
    char[][] grid;
    int m,n;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        visited = new Boolean[n][m];
        this.grid = grid;
        int ctr=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=false;
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && (grid[i][j]=='1')){
                    ctr++;
                    dfs(i,j);
                }
            }
        }
        
        return ctr;
    }
    
    private void dfs(int i,int j){
        if(visited[i][j]){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
         
        visited[i][j]=true;
        
        
        
        for(int k=0;k<directions.length;k++){
            if(i+directions[k][0] <n && i+directions[k][0] >=0 && j+directions[k][1] <m && j+directions[k][1] >=0){
                dfs(i+directions[k][0], j + directions[k][1]);
            }
        }
        
        
    }
}