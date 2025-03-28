class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean vis[][] = new boolean[rows][cols];
        // At first we will traverse the first and the last row
        for (int i = 0; i < cols; i++) {
            //traversing the first row
            if (vis[0][i] == false && board[0][i] == 'O') {
                dfs(0, i, vis, board);
            }
            if (vis[rows - 1][i] == false && board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, vis, board);
            }
        }
        // traversing the first and the last column
        for(int i=0;i<rows;i++){
            if(vis[i][0]==false && board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
            if(vis[i][cols-1]==false && board[i][cols-1]=='O'){
                dfs(i,cols-1,vis,board);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(vis[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int row,int col,boolean vis[][],char board[][]){
        int rows=board.length;
        int cols=board[0].length;
        vis[row][col]=true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nRow=row+i;
                int nCol=col+j;
                if((i==0 || j==0) && (nRow >=0) && (nCol >= 0) && (nRow<rows) && (nCol < cols) && vis[nRow][nCol]==false && board[nRow][nCol]=='O'){
                    dfs(nRow,nCol,vis,board);
                }
            }
        }
    }
}