class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        
        int res = findingNumberOfCoins(coins, amount, coins.length - 1,dp);
        return (res >= (int) Math.pow(10, 8)) ? -1 : res;
    }

    private int findingNumberOfCoins(int coins[], int amount, int ind,int dp[][]) {
        if (amount == 0) return 0;  
        if (ind < 0) return (int) Math.pow(10, 8); 
        if(dp[ind][amount]!= -1) return dp[ind][amount];
        int take = (int) Math.pow(10, 8);
        if (coins[ind] <= amount) {
            take = 1 + findingNumberOfCoins(coins, amount - coins[ind], ind,dp);
        }
        int not_take = findingNumberOfCoins(coins, amount, ind - 1,dp);
        return dp[ind][amount]=Math.min(take, not_take);
    }
}
