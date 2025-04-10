class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, maxLen = 0;
        Queue<Integer> zeroIndices = new LinkedList<>();

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroIndices.add(end);
            }
            if (zeroIndices.size() > k) {
                start = zeroIndices.poll() + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }
}
