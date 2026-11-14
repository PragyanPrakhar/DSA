class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int end = 0;
        int minSum = Integer.MAX_VALUE;

        while (end < nums.size()) {
            int currentSum = 0;
            int start = end;
            while (start >= 0 && end - start + 1 <= r) {
                currentSum += nums.get(start);
                if (end - start + 1 >= l && currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
                start--;
            }
            end++;
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
