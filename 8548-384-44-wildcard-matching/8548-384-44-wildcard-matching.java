// class Solution {
//     public boolean isMatch(String s, String p) {
//         int dp[][]=new int[s.length()+1][p.length()+1];
//         for(int[] ar:dp) Arrays.fill(ar,-1);
//         return solve(s, p, s.length(), p.length(),dp);
//     }

//     private boolean solve(String s, String p, int m, int n,int dp[][]) {
//         if (m == 0 && n == 0) {
//             return true;
//         }
//         if (n == 0) {
//             return false;
//         }
//         if (m == 0) {
//             for (int i = 0; i < n; i++) {
//                 if (p.charAt(i) != '*')
//                     return false;
//             }
//             return true;
//         }
//         if(dp[m][n]!=-1) return dp[m][n]==1?true:false;
//         if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?') {
//             return solve(s, p, m - 1, n - 1,dp);
//         } else {
//             if (p.charAt(n - 1) == '*') {
//                 boolean ans= solve(s, p, m - 1, n,dp) || solve(s,p,m,n-1,dp);
//                 if(ans){
//                     dp[m][n]=1;
//                 }
//                 else{
//                     dp[m][n]=0;
//                 }
//             }
//         }
//         dp[m][n]=0;
//         return false;
//     }
// }
import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];

        // Initialize DP table with -1 (indicating uncomputed states)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, p, s.length(), p.length(), dp);
    }

    private boolean solve(String s, String p, int m, int n, int[][] dp) {
        // Base cases
        if (m == 0 && n == 0) return true;  // Both strings exhausted → Match found
        if (n == 0) return false; // Pattern exhausted but string remains → No match
        if (m == 0) {
            // If string is exhausted, check if remaining pattern is all '*'
            for (int i = 0; i < n; i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        // If already computed, return stored result (1 -> true, 0 -> false)
        if (dp[m][n] != -1) return dp[m][n] == 1;

        boolean result;

        // If characters match OR wildcard '?'
        if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?') {
            result = solve(s, p, m - 1, n - 1, dp);
        }
        // If pattern character is '*', it can match zero or more characters
        else if (p.charAt(n - 1) == '*') {
            result = solve(s, p, m - 1, n, dp) || solve(s, p, m, n - 1, dp);
        } else {
            result = false;
        }

        // Store result as 1 (true) or 0 (false) in dp table
        dp[m][n] = result ? 1 : 0;

        return result;
    }
}
