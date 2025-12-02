class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // initialize to first triplet

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];

                // update closest sum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum == target) {
                    return target;  // best possible
                } else if (currentSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return closestSum;
    }
}
