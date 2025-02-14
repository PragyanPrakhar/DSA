class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
         
    }
    // private int climbing(int[] dp,int n)
    // {
    //     if(n==0 || n==1)
    //     {
    //         return 1;
    //     }
    //     if(n<1) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=climbing(dp,n-1)+climbing(dp,n-2);
    // }
    
}