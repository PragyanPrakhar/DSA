class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int pick=nums[i];
            int not_pick=Integer.MIN_VALUE;
            if(i>1)
            {
                pick+=dp[i-2];
            }
                not_pick=dp[i-1];

            dp[i]=Math.max(pick,not_pick);
        }

        return dp[nums.length-1];
    }

    // private int finding(int[] nums, int ind,int dp[]) {
    //     if (ind == 0)
    //         return nums[0];

    //     if(ind < 0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int pick=nums[ind]+finding(nums,ind-2,dp);
    //     int not_pick=finding(nums,ind-1,dp);
    //     return dp[ind]=Math.max(pick,not_pick);
    // }
}