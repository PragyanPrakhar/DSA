class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];
        // The approach is like we need to find the minimum sum and then we have to subtract it from the total sum to get the required result , and yes if the maxSum is negative only then it means all the elements of the array are negative , then we will return the maxSum directly.
        for (int i = 0; i < nums.length; i++) {

            totalSum += nums[i];

            if (i > 0) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }

        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        int circularMax = totalSum - minSum;

        return Math.max(maxSum, circularMax);
    }
}