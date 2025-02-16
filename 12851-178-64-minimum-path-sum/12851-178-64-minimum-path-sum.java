class Solution {
    public int minPathSum(int[][] grid) {
        // Trying out all the paths --> Recursive Approach
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        dp[0][0] = 1;
        return finding(m - 1, n - 1, grid, dp);
    }

    private int finding(int m, int n, int[][] grid,int[][] dp) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[m][n];
        if(dp[m][n]!=-1) return dp[m][n];
        int up = finding(m - 1, n, grid,dp);
        int left = finding(m, n - 1, grid,dp);
        return dp[m][n]=(grid[m][n] + Math.min(up, left));
    }
}
// class Solution {
// public int minPathSum(int[][] grid) {
// int m = grid.length;
// int n = grid[0].length;
// return finding(m - 1, n - 1, grid);
// }

// private int finding(int m, int n, int[][] grid) {
// if (m < 0 || n < 0) return Integer.MAX_VALUE; // Avoid out-of-bounds
// if (m == 0 && n == 0) return grid[0][0]; // Base case

// int up = finding(m - 1, n, grid);
// int left = finding(m, n - 1, grid);

// return grid[m][n] + Math.min(up, left);
// }
// }
