import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int left = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            while (hs.contains(nums[right])) {
                hs.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            hs.add(nums[right]);
            sum += nums[right];

            if (hs.size() == k) {
                maxSum = Math.max(maxSum, sum);
                // Remove left element to maintain window size
                hs.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
