class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int targetSum = sum / 2;
        int dp[][] = new int[nums.length][targetSum + 1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        return isPossible(nums, nums.length - 1, targetSum, dp);
    }

    private boolean isPossible(int nums[], int ind, int targetSum, int dp[][]) {
        if (ind == 0) {
            if (targetSum == nums[0])
                return true;
            else
                return false;
        }
        if (ind < 0)
            return false;
        if (targetSum == 0)
            return true;
        if(dp[ind][targetSum]!=-1){
            return dp[ind][targetSum]==1?true:false;
        }
        boolean not_take = isPossible(nums, ind - 1, targetSum,dp);
        boolean take = false;
        if (nums[ind] <= targetSum) {
            take = isPossible(nums, ind - 1, targetSum - nums[ind],dp);
        }
        dp[ind][targetSum]=(take || not_take)?1:0;
        return take||not_take;
    }
}