class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(0,-1,nums,dp);
    }
    private int solve(int i,int prevIndex,int nums[],int dp[][]){
        if(i==nums.length) return 0;
        if(dp[i][prevIndex+1]!=-1) return dp[i][prevIndex+1];
        int len=solve(i+1,prevIndex,nums,dp);
        if(prevIndex==-1 || nums[i]>nums[prevIndex]){
            len=Math.max(len,1+solve(i+1,i,nums,dp));
        }
        return dp[i][prevIndex+1]=len;
    }
}