class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int n=nums.length;
        int targetSum = sum / 2;
        boolean dp[][] = new boolean[nums.length][targetSum + 1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=targetSum){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=targetSum;j++){
                boolean not_take=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=take || not_take;
            }
        }
        return dp[n-1][targetSum];
    }

    // private boolean isPossible(int nums[], int ind, int targetSum, int dp[][]) {
    //     if (ind == 0) {
    //         if (targetSum == nums[0])
    //             return true;
    //         else
    //             return false;
    //     }
    //     if (ind < 0)
    //         return false;
    //     if (targetSum == 0)
    //         return true;
    //     if(dp[ind][targetSum]!=-1){
    //         return dp[ind][targetSum]==1?true:false;
    //     }
    //     boolean not_take = isPossible(nums, ind - 1, targetSum,dp);
    //     boolean take = false;
    //     if (nums[ind] <= targetSum) {
    //         take = isPossible(nums, ind - 1, targetSum - nums[ind],dp);
    //     }
    //     dp[ind][targetSum]=(take || not_take)?1:0;
    //     return take||not_take;
    // }
}