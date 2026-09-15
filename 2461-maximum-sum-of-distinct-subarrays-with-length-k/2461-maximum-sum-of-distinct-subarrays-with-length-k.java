class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        long maxSum=0;
        int start=0;
        int end=0;
        long currentSum=0;
        while(end < nums.length){
            while(hs.contains(nums[end])){
                hs.remove(nums[start]);
                currentSum-=nums[start];
                start++;
            }
            currentSum+=nums[end];
            hs.add(nums[end]);
            if(end-start+1 == k){
                maxSum = Math.max(currentSum , maxSum);
                hs.remove(nums[start]);
                currentSum-=nums[start];
                start=start+1;
            }
            end++;
        }   
        return maxSum;
    }
}