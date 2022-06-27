class Solution {
    int R,C;
    public boolean exist(char[][] board, String word) {
        R=board.length;
        C=board[0].length;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]==word.charAt(0) && helper(word,board,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public  boolean helper(String word, char[][] board, int i, int j,int count){
        if(count==word.length()){
            return true;
        }
        
        if(i>=R || i<0 || j>=C || j<0 ||board[i][j]!=word.charAt(count)){
            return false;
        }
        
        char temp = board[i][j];
        board[i][j]=' ';
        boolean found= (helper(word,board,i+1,j,count+1)||helper(word,board,i,j+1,count+1)||helper(word,board,i-1,j,count+1)||helper(word,board,i,j-1,count+1));
        board[i][j]=temp;
        return found;
        
    }
}