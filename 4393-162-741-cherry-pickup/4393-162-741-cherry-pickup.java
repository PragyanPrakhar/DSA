class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        // int N = grid.length;
        int[][][][] dp = new int[N][N][N][N];

        // Fill with -1 using nested loops
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        return Math.max(0, cherryPick(grid, N, 0, 0, 0, 0, dp));
    }

    private int cherryPick(int[][] grid, int N, int r1, int c1, int r2, int c2, int dp[][][][]) {
        if (r1 >= N || c1 >= N || r2 >= N || c2 >= N || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == N - 1 && c1 == N - 1) {
            return grid[r1][c1];
        }
        if (r2 == N - 1 && c2 == N - 1) {
            return grid[r2][c2];
        }
        if (dp[r1][c1][r2][c2] != -1)
            return dp[r1][c1][r2][c2];
        int cherries;
        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }
        cherries += Math.max(
                Math.max(cherryPick(grid, N, r1 + 1, c1, r2 + 1, c2, dp),
                        cherryPick(grid, N, r1 + 1, c1, r2, c2 + 1, dp)),
                Math.max(cherryPick(grid, N, r1, c1 + 1, r2 + 1, c2, dp),
                        cherryPick(grid, N, r1, c1 + 1, r2, c2 + 1, dp)));
        return dp[r1][c1][r2][c2] = cherries;
    }
}