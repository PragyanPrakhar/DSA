class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            currSum += num;
            if (prefixSumCount.containsKey(currSum - k)) {
                count += prefixSumCount.get(currSum - k);
            }
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
