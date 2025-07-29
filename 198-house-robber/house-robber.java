class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return recurr(nums,0,dp);
    }
    private int recurr(int nums[],int index,int dp[]){
        if(index>nums.length-1){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];
        int pick=nums[index]+recurr(nums,index+2,dp);
        int not_pick=0+recurr(nums,index+1,dp);
        return dp[index]=Math.max(pick,not_pick);
    }
}