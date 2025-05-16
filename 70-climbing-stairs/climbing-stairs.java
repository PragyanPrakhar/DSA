class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        int ind=0;
        dp[n]=1;
        dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];

        // return solve(ind,n,dp);
    }
    //Memoization Approach
    private int solve(int ind,int n,int dp[]){
        if(ind>n) return 0;
        if(ind==n) return 1;
        if(dp[ind]!=-1) return dp[ind];
        return dp[ind]=solve(ind+1,n,dp)+solve(ind+2,n,dp);
    }
}