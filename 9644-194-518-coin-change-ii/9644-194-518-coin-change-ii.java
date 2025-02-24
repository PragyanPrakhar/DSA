class Solution {
    public int change(int amount, int[] coins) {
        // Tabulation Approach(Bottom Up)
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int target=0;target<=amount;target++){
                int not_take=dp[i-1][target];
                int take=0;
                if(coins[i]<=target){
                    take=dp[i][target-coins[i]];
                }
                dp[i][target]=take+not_take;
            }
        }
        return dp[coins.length-1][amount];
    }

}