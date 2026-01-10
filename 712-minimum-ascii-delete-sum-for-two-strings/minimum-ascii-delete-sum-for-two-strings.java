class Solution {
    int n1, n2;
    int[][] dp;

    // Find the ASCII sum of LCS
    private int LCS(int x, int y, String w1, String w2) {
        if (x == n1 || y == n2) return 0;

        if (dp[x][y] != -1) return dp[x][y];

        int sum;
        if (w1.charAt(x) == w2.charAt(y)) {
            // here char is being added with the integer value then it is automatically being converted into integer by java.
            sum = w1.charAt(x) + LCS(x + 1, y + 1, w1, w2);
        } else {
            sum = Math.max(
                LCS(x + 1, y, w1, w2),
                LCS(x, y + 1, w1, w2)
            );
        }

        return dp[x][y] = sum;
    }

    public int minimumDeleteSum(String s1, String s2) {
        n1 = s1.length();
        n2 = s2.length();

        dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }

        int asciiSum = 0;
        for (char c : s1.toCharArray()) asciiSum += c;
        for (char c : s2.toCharArray()) asciiSum += c;

        return asciiSum - 2 * LCS(0, 0, s1, s2);
    }
}
