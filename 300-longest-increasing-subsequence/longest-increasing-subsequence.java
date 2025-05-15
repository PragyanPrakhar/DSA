class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int count=0;
        int dp[]=new int[n];
        int maxi=Integer.MIN_VALUE;
        Arrays.fill(dp,1);
        for(int i=0;i<dp.length;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[prev]);
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}