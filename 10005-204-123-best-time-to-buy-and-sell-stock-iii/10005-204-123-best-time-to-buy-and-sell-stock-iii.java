class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][3];
        // for(int mat[][]:dp){
        // for(int ar[]:mat){
        // Arrays.fill(ar,-1);
        // }
        // }

        // Tabulation Approach:->
        // Base Case:
        int n = prices.length;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[n][i][j] = 0;
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j][2] = 0;
            }
        }
        int profit=0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if(j==1){
                        dp[i][j][k]= Math.max((-prices[i] + dp[i+1][0][k]), dp[i+1][1][k]);
                    }
                    else{
                        dp[i][j][k] = Math.max((prices[i] + dp[i+1][1][k-1]),(dp[i+1][0][k]));
                    }
                }
            }
        }
        return dp[0][1][2];

        // return solve(prices, 0, 1, 0,dp);
    }

    // Recursive and Memoization Approach
    private int solve(int prices[], int ind, int buy, int count, int dp[][][]) {
        if (ind == prices.length)
            return 0;
        int profit = 0;
        if (count == 2)
            return profit;
        if (dp[ind][buy][count] != -1)
            return dp[ind][buy][count];
        if (buy == 1) {
            profit = Math.max((-prices[ind] + solve(prices, ind + 1, 0, count, dp)),
                    (0 + solve(prices, ind + 1, 1, count, dp)));
        } else if (buy == 0) {
            profit = Math.max((prices[ind] + solve(prices, ind + 1, 1, count + 1, dp)),
                    (0 + solve(prices, ind + 1, 0, count, dp)));
        }
        return dp[ind][buy][count] = profit;
    }
}