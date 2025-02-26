class Solution {
    public int maxProfit(int[] prices) {
        int buy=1;
        int dp[][]=new int[prices.length+1][2];
        // for(int[] ar:dp) {
        //     Arrays.fill(ar,-1);
        // }
        // Tabulation Approach

        // In tabulation at first we need to consider and fill the dp matrix according to the base case.
        // for(int i=0;i)
        dp[prices.length][0]=0;
        dp[prices.length][1]=0;
        int profit=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){
                    profit=Math.max((prices[i]+dp[i+1][1]),(0+dp[i+1][0]));
                }
                else{
                    profit=Math.max((-prices[i]+dp[i+1][0]),(0+dp[i+1][1]));
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];


        // return solve(prices,0,buy,dp);
    }

    //Memoization Approach
    private int solve(int prices[],int ind,int buy,int dp[][]){
        if(ind==prices.length) return 0;
        int profit=0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            profit=Math.max((-prices[ind]+solve(prices,ind+1,0,dp)),(0+solve(prices,ind+1,1,dp)));
        }
        else{
            profit=Math.max((prices[ind]+solve(prices,ind+1,1,dp)),0+solve(prices,ind+1,0,dp));
        }
        return dp[ind][buy]=profit;
    }
}