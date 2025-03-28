class Solution {
    public int numEnclaves(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean vis[][] = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if ((i == 0 || j == 0 || i == numRows - 1 || j == numCols - 1) && vis[i][j] == false
                        && grid[i][j] == 1) {
                    dfs(i, j, grid, vis);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (vis[i][j] == false && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int row, int col, int grid[][], boolean vis[][]) {
        vis[row][col]=true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nRow=row+i;
                int nCol=col+j;
                if((i==0 || j==0) && nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && vis[nRow][nCol]==false && grid[nRow][nCol]==1){
                    dfs(nRow,nCol,grid,vis);
                }
            }
        }
    }
}