class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(grid,0,0,dp);

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