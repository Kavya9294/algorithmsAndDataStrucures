/*
Instead of creating a grid, you need to count the row,
col, diagonal and antidiagonal only.
This way, save space and dont add each time, add as you go
*/


class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antiDiagonal = 0;
    int size;
    public TicTacToe(int n) {
      rows = new int[n];
      cols = new int[n];
        size = n;
    }
    
    public int move(int row, int col, int player) {
        int pValue = player == 1? 1: -1;
        
        rows[row] += pValue;
        cols[col] += pValue;
        
        if(row == col ) diagonal += pValue;
        if(row == size - col - 1) antiDiagonal += pValue;
        
        if(Math.abs(rows[row]) == size
          || Math.abs(cols[col]) ==size ||
          Math.abs(diagonal) == size ||
          Math.abs(antiDiagonal) == size){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */