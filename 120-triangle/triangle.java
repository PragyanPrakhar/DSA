class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n]; // dp[r][c] = min path sum from (r,c) to bottom

        // Base: last row
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        // Fill bottom-up
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                int cur = triangle.get(r).get(c);
                dp[r][c] = cur + Math.min(dp[r+1][c], dp[r+1][c+1]);
            }
        }

        return dp[0][0];
    }
}
