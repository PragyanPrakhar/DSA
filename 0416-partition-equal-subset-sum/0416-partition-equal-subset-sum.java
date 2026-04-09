class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=Arrays.stream(nums).sum();
        if(totalSum % 2 != 0) return false;
        int targetSum=totalSum / 2;
        boolean dp[][]=new boolean[nums.length+1][targetSum+1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= targetSum; j++) {
            dp[0][j] = false;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=targetSum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}