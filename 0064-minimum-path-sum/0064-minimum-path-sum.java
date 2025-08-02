class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        int rows=grid.length;
        int cols=grid[0].length;
        dp[0][0]=grid[0][0];
        for(int i=1;i<cols;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int j=1;j<rows;j++){
            dp[j][0]=dp[j-1][0]+grid[j][0];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[rows-1][cols-1];
    }
    private int solve(int grid[][],int row,int col , int dp[][]){
        if(row > grid.length-1 || col > grid[0].length-1){
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(dp[row][col]!=-1) return dp[row][col];

        int down=solve(grid,row+1,col,dp);
        int right=solve(grid,row,col+1,dp);
        return dp[row][col]=grid[row][col]+Math.min(down,right);
    }
}