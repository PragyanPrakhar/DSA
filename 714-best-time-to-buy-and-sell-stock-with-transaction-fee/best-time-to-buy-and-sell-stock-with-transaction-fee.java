class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return solve(prices,0,fee,1,dp);
    }
    private int solve(int prices[],int ind,int fee,int buy,int dp[][]){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[ind]+solve(prices,ind+1,fee,0,dp)),(0+solve(prices,ind+1,fee,1,dp)));
        }
        else{
            profit=Math.max((prices[ind]+solve(prices,ind+1,fee,1,dp)-fee),(0+solve(prices,ind+1,fee,0,dp)));
        }
        return dp[ind][buy]=profit;
    }
}