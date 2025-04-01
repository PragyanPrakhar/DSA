class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(found(i,j,board,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean found(int row,int col,char[][] board,String word,int ind){
        if(ind==word.length()) return true;
        if(row>=board.length || row<0 || col>=board[0].length || col<0){
            return false;
        }
        
        if(word.charAt(ind)!=board[row][col]) return false;
        char temp=board[row][col];
        board[row][col]='*';
        boolean left=found(row,col-1,board,word,ind+1);
        boolean up=found(row-1,col,board,word,ind+1);
        boolean down=found(row+1,col,board,word,ind+1);
        boolean right=found(row,col+1,board,word,ind+1);
        board[row][col]=temp;
        return (left||up||down||right); 
    }
}