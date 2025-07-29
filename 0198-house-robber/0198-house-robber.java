class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            int not_pick=Integer.MIN_VALUE;
            if(i>1){
                pick+=dp[i-2];
            }
            not_pick=dp[i-1];
            dp[i]=Math.max(pick,not_pick);
        }
        return dp[nums.length-1];
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