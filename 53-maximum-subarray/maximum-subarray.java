class Solution {
    public int maxSubArray(int[] nums) {
        int cS=nums[0];
        int mS=nums[0];
        for(int i=1;i<nums.length;i++){
            cS=Math.max(nums[i]+cS , nums[i]);
            // if(cS<0) cS=0;
            mS=Math.max(mS,cS);
        }
        return mS;
    }
}