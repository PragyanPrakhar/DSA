class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=nums.length+1;
        int sum=0;
        int start=0;
        int end=0;
        while(end < nums.length){
            sum+=nums[end];
            while(sum >= target){
                sum-=nums[start];
                minLen=Math.min(minLen,end-start+1);
                start++;
            }
            end++;
        }
        return minLen==nums.length+1 ? 0 : minLen;
    }
}