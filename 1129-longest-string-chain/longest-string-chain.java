class Solution {
    private boolean isPossible(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(n-m!=1) return false;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            if (j < n && i < m && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                if (count > 1)
                    return false;
                j++;
            }
        }
        if (i == m)
            return true;
        return false;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[words.length];
        int maxi = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPossible(words[j], words[i])) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;

    }
}