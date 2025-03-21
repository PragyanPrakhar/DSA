class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return solve(m,n,0,0,dp);
    }
    private int solve(int m,int n,int i,int j,int dp[][]){
        if(i==m-1 && j==n-1) return 1;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(m,n,i,j+1,dp);
        int down=solve(m,n,i+1,j,dp);
        return dp[i][j]=right+down;
    }
}