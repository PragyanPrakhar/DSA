class Solution {
    public int maxProfit(int cap, int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][cap+1];
        // for(int mat[][]:dp){
        // for(int ar[]:mat){
        // Arrays.fill(ar,-1);
        // }
        // }
        // return solve(prices, k, 0, 1, dp);

        // Tabulation Approach:->

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= cap; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max((-prices[i] +dp[i+1][0][k]),
                                (0 + dp[i+1][1][k]));
                    } else {
                        dp[i][j][k] = Math.max((prices[i] +dp[i+1][1][k-1]),
                                (0 + dp[i+1][0][k]));
                    }
                }
            }
        }
        return dp[0][1][cap];

    }

    // recursive and memoization approach
    // here k is equal to the cap , I have changed the signature name of k to cap in
    // the tabulation approach.
    private int solve(int prices[], int k, int ind, int buy, int dp[][][]) {
        if (ind == prices.length || k == 0)
            return 0;
        int profit = 0;
        if (dp[ind][buy][k] != -1)
            return dp[ind][buy][k];
        if (buy == 1) {
            profit = Math.max((-prices[ind] + solve(prices, k, ind + 1, 0, dp)),
                    (0 + solve(prices, k, ind + 1, 1, dp)));
        } else {
            profit = Math.max((prices[ind] + solve(prices, k - 1, ind + 1, 1, dp)),
                    (0 + solve(prices, k, ind + 1, 0, dp)));
        }
        return dp[ind][buy][k] = profit;

    }
}