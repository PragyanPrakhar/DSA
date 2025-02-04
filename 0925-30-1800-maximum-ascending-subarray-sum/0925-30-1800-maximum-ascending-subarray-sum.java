class Solution {
    public int maxAscendingSum(int[] nums) {
        if(nums.length==1) return nums[0];
        int max=nums[0];
        int currentSum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currentSum=nums[i]>nums[i-1] ? currentSum+=nums[i] : nums[i];
            max=Math.max(currentSum,max);
        }
        return max;
    }
}