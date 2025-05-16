class Solution {
    public int coinChange(int[] coins, int amount) {
        int ind = 0;
        int dp[][] = new int[coins.length][amount + 1];
        // for(int i=1;i<=amount;i++){
        //     if(amount%i==0){
        //         dp[coins.length-1][i]=amount/i;
        //     }
        // }
        for (int j = 0; j <= amount; j++) {
            if (j % coins[coins.length - 1] == 0)
                dp[coins.length - 1][j] = j / coins[coins.length - 1];
            else
                dp[coins.length - 1][j] = (int) 1e8;
        }

        for (int i = coins.length - 2; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[i + 1][j];
                int take = (int)1e8;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, not_take);
            }
        }
        return dp[0][amount]==(int)1e8 ? -1 : dp[0][amount];

        // for(int ar[]:dp){
        //     Arrays.fill(ar,-1);
        // }
        // int res= solve(ind,coins,amount,dp);
        // return res==(int)Math.pow(10,8)?-1:res;

    }

    //Memoization Approach
    private int solve(int ind, int coins[], int amount, int dp[][]) {
        if (amount == 0)
            return 0;
        if (ind == coins.length - 1) {
            if (amount % coins[ind] == 0)
                return amount / coins[ind];
            else
                return (int) Math.pow(10, 8);
        }
        if (ind >= coins.length)
            return (int) Math.pow(10, 8);
        if (dp[ind][amount] != -1)
            return dp[ind][amount];
        int not_take = solve(ind + 1, coins, amount, dp);
        int take = 0;
        if (coins[ind] <= amount) {
            take = 1 + solve(ind, coins, amount - coins[ind], dp);
        }
        return dp[ind][amount] = Math.min(take, not_take);
    }
}