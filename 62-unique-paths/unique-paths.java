class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        int i=0;
        int j=0;
        return solve(i,j,m,n,dp);
    }
    private int solve(int i,int j,int m,int n,int dp[][]){
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int down=solve(i+1,j,m,n,dp);
        int right=solve(i,j+1,m,n,dp);
        return dp[i][j]=down+right;

    }
}