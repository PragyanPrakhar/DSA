class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        // for (int[] arr : dp) {
        //     Arrays.fill(arr, -1);
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    // continue;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    // continue;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
        // dp[0][0]=1;
        // return finding(m-1,n-1,obstacleGrid,dp);

        // Tabulation Approach

    }

    // private int finding(int m, int n, int[][] obstacleGrid, int[][] dp) {
    // if (m == 0 && n == 0)
    // return 1;
    // if (m < 0 || n < 0)
    // return 0;
    // if (obstacleGrid[m][n] == 1)
    // return 0;
    // if (dp[m][n] != -1)
    // return dp[m][n];
    // int up = finding(m - 1, n, obstacleGrid, dp);
    // int left = finding(m, n - 1, obstacleGrid, dp);
    // return dp[m][n] = (up + left);
    // }
}