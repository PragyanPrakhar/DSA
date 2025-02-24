class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=Arrays.stream(nums).sum();
        if(sum<target) return 0;
        if((sum-target)%2 ==1) return 0;
        int tar=(sum-target)/2;
        int dp[][]=new int[nums.length][tar+1];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(nums,tar,nums.length-1,dp);
    }
    private int solve(int nums[],int target,int ind,int dp[][]){
        if(ind==0){
            if(target==0 && nums[0]==0) return 2;
            if(target==0 || nums[0]==target) return 1;
            return 0;
        }
        if(target<0 || ind<0) return 0;
        if(dp[ind][target]!= -1) return dp[ind][target];
        int take=0;
        if(nums[ind]<=target){
            take=solve(nums,target-nums[ind],ind-1,dp);
        }
        int not_take=solve(nums,target,ind-1,dp);
        return dp[ind][target]=take+not_take;
    }

}