class Solution {
    int n = 3;
    char[][] board;
    
    public boolean isValid(char num, int row, int col){
        int r = (row/n) *n;
        int c = (col/n) *n;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num || 
              board[r + i/n][c + i% n] == num){
                return false;
            }
        }
        return true;
    }
    
    public boolean solve(int row, int col){
        for( int i = row; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char num = '1'; num <= '9'; num++ ){
                        if(isValid(num, i, j)){
                            board[i][j] = num;
                            if(solve(i,j+1))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0,0);
    }
}