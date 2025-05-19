class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(-1,dp,0,nums);
    }
    private int solve(int prevIndex,int dp[][],int currentIndex,int nums[]){
        if(currentIndex>=nums.length) return 0;
        if(dp[prevIndex+1][currentIndex]!=-1) return dp[prevIndex+1][currentIndex];
        int not_take=solve(prevIndex,dp,currentIndex+1,nums);
        int take=0;
        if(prevIndex==-1 || nums[prevIndex]<nums[currentIndex]){
            take=1+solve(currentIndex,dp,currentIndex+1,nums);
        }
        return dp[prevIndex+1][currentIndex]=Math.max(take,not_take);
    }
}