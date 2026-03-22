class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        int left=0;
        long sum=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int right=0;right<nums.length;right++){
            while(hs.contains(nums[right])){
                hs.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            sum+=nums[right];
            hs.add(nums[right]);
            if(hs.size()==k){
                maxSum=Math.max(maxSum,sum);
                hs.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
        }
        return maxSum;
    }
}