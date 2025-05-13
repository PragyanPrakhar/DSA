class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        int nums1[] = new int[nums.length - 1];// excluding index 0 element
        int nums2[] = new int[nums.length - 1];// excluding last index element
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                nums2[n2++] = nums[i];
            if (i != nums.length - 1)
                nums1[n1++] = nums[i];
        }
        int dp1[] = new int[nums1.length];
        int dp2[] = new int[nums2.length];

        int solution_one = solve(nums1, dp1);
        int solution_two = solve(nums2, dp2);
        return Math.max(solution_one, solution_two);

    }

    private int solve(int nums[], int dp[]) {
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            int not_pick = Integer.MIN_VALUE;
            if (i > 1) {
                pick += dp[i - 2];
            }
            not_pick = dp[i - 1];

            dp[i] = Math.max(pick, not_pick);
        }
        return dp[nums.length - 1];

    }
}