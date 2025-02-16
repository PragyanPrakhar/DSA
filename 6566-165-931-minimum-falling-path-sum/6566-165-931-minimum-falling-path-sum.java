class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = matrix[i][j];
                if (j > 0)
                    leftDiagonal += dp[i - 1][j - 1];
                else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }
                int rightDiagonal = matrix[i][j];
                if (j < m - 1)
                    rightDiagonal += dp[i-1][j + 1];
                else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        for (int num : dp[m - 1]) {
            ans = Math.min(num, ans);
        }
        return ans;
    }
}