class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][2];
        for(int arr[][]:dp){
            for(int ar[]:arr){
                Arrays.fill(ar,-1);
            }
        }
        int buy=1;
        return solve(0,buy,0,dp,prices);
    }
    private int solve(int ind,int buy,int count,int dp[][][],int prices[]){
        if(ind==prices.length) return 0;
        int profit=0;
        if(count==2) return profit;
        if(dp[ind][buy][count]!=-1) return dp[ind][buy][count];
        if(buy==1){
            profit=Math.max((-prices[ind]+solve(ind+1,0,count,dp,prices)),(0+solve(ind+1,1,count,dp,prices)));
        }
        else{
            profit=Math.max((prices[ind]+solve(ind+1,1,count+1,dp,prices)),(0+solve(ind+1,0,count,dp,prices)));
        }
        return dp[ind][buy][count]=profit;
    }
}