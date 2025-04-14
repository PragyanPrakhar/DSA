class Solution {
    public int lengthOfLIS(int[] nums) {
        int ind=nums.length-1;
        int dp[][]=new int[nums.length][nums.length+1];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(nums,0,-1,dp);
    }
    private int solve(int nums[],int ind,int prevIndex,int dp[][]){
        if(ind==nums.length) return 0;
        if(dp[ind][prevIndex+1]!=-1) return dp[ind][prevIndex+1];
        int not_take=0+solve(nums,ind+1,prevIndex,dp);
        int take=0;
        if(prevIndex==-1 || nums[ind]>nums[prevIndex]){
            take=1+solve(nums,ind+1,ind,dp);
        }
        return dp[ind][prevIndex+1]=Math.max(take,not_take);
    }
}