class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];
        Arrays.fill(lis, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }
        int ans = 0;
        for (int num : lis) {
            ans = Math.max(ans, num);
        }

        return ans;
    }
}
