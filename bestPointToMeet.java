class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        //Collect in sorted order to begin in
        //sorting adds log(mn). here its just O(mn)
        for(int i =0; i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rows.add(i);
                    // cols.add(j);
                }
            }
        }
        
        for(int i =0; i< grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    cols.add(i);
                }
            }
        }
        
        
        int medRow = rows.get((int)rows.size()/2);
        int medCol = cols.get((int)cols.size()/2);
        
        int sum = 0;
        for(int i = 0;i<rows.size();i++){
            sum+=Math.abs(rows.get(i)-medRow);
            sum+=Math.abs(cols.get(i)-medCol);
        }
        
        return sum;
    }
}