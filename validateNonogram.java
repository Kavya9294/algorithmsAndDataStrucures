// matrix1 = [[1,1,1,1],
//            [0,1,1,1],
//            [0,1,0,0],
//            [1,1,0,1],
//            [0,0,1,1]]
// rows1_1    =  [], [1], [1,2], [1], [2]
// columns1_1 =  [2,1], [1], [2], [1]
// validateNonogram(matrix1, rows1_1, columns1_1) => True

import java.util.*;

public class MyClass {
    public static void validateNonogram(int[][] matrix, int[][] rows, int[][] cols){
        boolean rowFlag = validRow(matrix,rows);
        boolean colFlag = validCol(matrix,cols);

        System.out.println(rowFlag && colFlag);
    }

    public static boolean validRow(int[][] matrix, int[][] rows){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            int rowIndex = 0;
            for( int j = 0; j < m ; j++){
                if(matrix[i][j] == 0){
                    if( rows[i].length == 0 || rowIndex >= rows[i].length || j>0 && matrix[i][j-1] ==0){
                        return false;
                    }

                    for( int k = 0; k < rows[i][rowIndex]; k++){
                        if( j+k >= m || matrix[i][j+k]!= 0){
                            return false;
                        }
                    }
                    j += rows[i][rowIndex++];
                }
            }
            if(rowIndex != rows[i].length){
                return false;
            }
        }
        return true;
    }

    public static boolean validCol(int[][] matrix, int[][] cols){
        int n = matrix.length;
        int m = matrix[0].length;

        for( int i = 0; i< m ; i ++){
            int colIndex = 0;
            for(int j = 0; j < n ; j++){
                if(matrix[j][i] == 0){
                    if( cols[i].length == 0 || colIndex >= cols[i].length || j > 0 && matrix[j-1][i] == 0){
                        return false;
                    }

                    for( int k = 0; k < cols[i][colIndex]; k++){
                        if( j+k >= n || matrix[j+k][i] != 0 ){
                            return false;
                        }
                    }
                    j += cols[i][colIndex++];
                }
            }
            if( colIndex != cols[i].length){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
      int[][] matrix = {{1,1,1,1},
           {0,1,1,1},
           {0,1,0,0},
           {1,1,0,1},
           {0,0,1,1}};
    
        int[][] rows = {{}, {}, {1}, {1}, {1,1}};
        int[][] cols = {{2,1}, {1}, {2}, {1}};
        
        validateNonogram(matrix, rows, cols);

    }
}