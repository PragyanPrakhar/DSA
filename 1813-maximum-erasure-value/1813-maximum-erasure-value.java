class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0, tempSum = 0, maxSum = 0;

        while (end < nums.length) {
            if (!set.contains(nums[end])) {
                set.add(nums[end]);
                tempSum += nums[end];
                maxSum = Math.max(maxSum, tempSum);
                end++;
            } else {
                set.remove(nums[start]);
                tempSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}
