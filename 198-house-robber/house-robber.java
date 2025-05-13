class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int not_pick=dp[i-1];
            // not_pick=dp
            dp[i]=Math.max(pick,not_pick);
        }
        return dp[nums.length-1];
        // int n=nums.length;
        // return soln(n-1,nums);
    }
    private int soln(int ind,int nums[]){
        if(ind<0) return 0;
        if(ind==0){
            return nums[ind];
        }
        int take=nums[ind]+soln(ind-2,nums);
        int not_take=soln(ind-1,nums);
        return Math.max(take,not_take);
    }
}