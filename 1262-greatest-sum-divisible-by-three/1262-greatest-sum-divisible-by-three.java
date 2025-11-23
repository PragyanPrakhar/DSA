class Solution {
    private Integer[][] memo;
    private int[] nums;

public int maxSumDivThree(int[] nums) {
    int sum = 0;
    List<Integer> mod1 = new ArrayList<>();
    List<Integer> mod2 = new ArrayList<>();

    for (int num : nums) {
        sum += num;
        if (num % 3 == 1) mod1.add(num);
        else if (num % 3 == 2) mod2.add(num);
    }

    int mod = sum % 3;

    if (mod == 0) return sum;

    Collections.sort(mod1);
    Collections.sort(mod2);

    int ans = 0;

    if (mod == 1) {
        int remove1 = mod1.size() > 0 ? mod1.get(0) : Integer.MAX_VALUE;
        int remove2 = mod2.size() > 1 ? (mod2.get(0) + mod2.get(1)) : Integer.MAX_VALUE;
        ans = sum - Math.min(remove1, remove2);
    }

    if (mod == 2) {
        int remove1 = mod2.size() > 0 ? mod2.get(0) : Integer.MAX_VALUE;
        int remove2 = mod1.size() > 1 ? (mod1.get(0) + mod1.get(1)) : Integer.MAX_VALUE;
        ans = sum - Math.min(remove1, remove2);
    }

    return ans < 0 ? 0 : ans;
}

    private int dfs(int idx, int mod) {
        if (idx == nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE; 
        }

        if (memo[idx][mod] != null) return memo[idx][mod];

        // Choice 1: take this number
        int take = dfs(idx + 1, (mod + nums[idx]) % 3);
        if (take != Integer.MIN_VALUE) {
            take += nums[idx];
        }

        // Choice 2: skip this number
        int skip = dfs(idx + 1, mod);

        return memo[idx][mod] = Math.max(take, skip);
    }
}
