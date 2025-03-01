class Solution {
    public int maxProfit(int[] prices) {
        // int dp[][] = new int[prices.length+2][2];
        // Tabulation Approach
        // for (int ind = prices.length-1; ind >= 0; ind--) {
        //     for (int buy = 0; buy <= 1; buy++) {
        //         if (buy == 1) {
        //             dp[ind][buy] = Math.max((-prices[ind]+dp[ind+1][0]),
        //                     (0 +dp[ind+1][1]));
        //         } else {
        //             dp[ind][buy] = Math.max((prices[ind]+dp[ind+2][1]),
        //                     (0 +dp[ind+1][0]));
        //         }
        //     }
        // }
        // return dp[0][1];
        
        //Space Optimization Approach:-
        int front1[]=new int[2];
        int front2[]=new int[2];
        int curr[]=new int[2];
        for (int ind = prices.length-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[1] = Math.max((-prices[ind]+front1[0]),
                            (0 +front1[1]));
                } else {
                    curr[0] = Math.max((prices[ind]+front2[1]),
                            (0 +front1[0]));
                }
            }
            front2=front1.clone();
            front1=curr.clone();
        }
    return curr[1];
    }

    // Recursive And Memoization Approach :-
    private int solve(int prices[], int ind, int buy, int dp[][]) {
        if (ind >= prices.length) {
            return 0;
        }
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[ind] + solve(prices, ind + 1, 0, dp)), (0 + solve(prices, ind + 1, 1, dp)));
        } else {
            profit = Math.max((prices[ind] + solve(prices, ind + 2, 1, dp)), (0 + solve(prices, ind + 1, 0, dp)));
        }
        return dp[ind][buy] = profit;
    }
}