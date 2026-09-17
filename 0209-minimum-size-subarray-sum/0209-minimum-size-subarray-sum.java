class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int currentSum=0;
        int minLen=nums.length;
        int totalSum=0;
        for(int i:nums){
            totalSum += i;
        }
        if(totalSum < target) return 0;
        while(end < nums.length){
            currentSum+=nums[end];
            while(currentSum >= target){
                minLen=Math.min(minLen , end-start+1);
                currentSum-=nums[start];
                start++;
            }
            end++;
        }
        return minLen;
    }
}