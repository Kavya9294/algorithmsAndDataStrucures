class Solution {
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;
        
        //Transpose
        //i=0, j = i+1
        for(int i=0;i<n;i++){
            for(int j = i+1; j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reflection
        //i remains same, only j is n-j-1
        for(int i=0;i<n;i++){
            for(int j = 0; j<m/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
        
    }
}