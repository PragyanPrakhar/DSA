class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int dp[][]=new int[m][n];
        // Tabulation Approach
        for(int i=0;i<matrix[0].length;i++){
            dp[matrix.length-1][i]=matrix[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int diagonalLeft=Integer.MAX_VALUE;
                if(j+1 < matrix[0].length && i+1 < matrix.length){
                    diagonalLeft=dp[i+1][j+1];
                }
                int diagonalRight=Integer.MAX_VALUE;
                if(i+1 < matrix.length && j-1 >=0){
                    diagonalRight=dp[i+1][j-1];
                }
                int down=Integer.MAX_VALUE;
                if(i+1 < matrix.length){
                    down=dp[i+1][j];
                }
                dp[i][j]=matrix[i][j]+Math.min(diagonalLeft,Math.min(diagonalRight,down));
            }
        }
        // finding the minimum in the first row;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,dp[0][i]);
        }
        return mini;


        // for(int ar[]:dp) Arrays.fill(ar,-1);
        // for (int i = 0; i < matrix[0].length; i++) {
        //     int tempAns = solve(m, n, 0, i, matrix,dp);
        //     min = Math.min(min, tempAns);
        // }
        // return min;
    }

    // Memoization Approach -> TLE in this question
    private int solve(int m, int n, int i, int j, int matrix[][],int dp[][]) {
        if (i == matrix.length) {
            return 0;
        }
        if(j>=matrix[0].length || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int diagonalLeft = solve(m, n, i + 1, j - 1, matrix,dp);
        int diagonalRight = solve(m, n, i + 1, j + 1, matrix,dp);
        int down =  solve(m, n, i + 1, j, matrix,dp);
        return dp[i][j]=matrix[i][j] + Math.min(diagonalLeft, Math.min(diagonalRight, down));
    }
}