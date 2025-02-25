//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Solution {
//     public int longestCommonSubstr(String s1, String s2) {
//         // code here
//         int m=s1.length();
//         int n=s2.length();
//         int[][][] dp = new int[m][n][Math.max(m, n)]; // DP array to store computed values
//         for (int[][] row : dp) {
//             for (int[] col : row) {
//                 Arrays.fill(col, -1);
//             }
//         }
//         return solve(s1,s2,m-1,n-1,0,dp);
//     }
//     private int solve(String s1, String s2,int m,int n,int count,int dp[][][]){
//         if(m<0 || n<0) return 0;
//         if (dp[m][n][count] != -1) return dp[m][n][count];
//         int currentCount=count;
//         if(s1.charAt(m)==s2.charAt(n)){
//             currentCount= solve(s1,s2,m-1,n-1,count+1,dp);
//         }
//         return dp[m][n][count]= Math.max(currentCount,Math.max(solve(s1,s2,m-1,n,0,dp),solve(s1,s2,m,n-1,0,dp)));
//     }
// }

// import java.util.Arrays;

// class Solution {
//     public int longestCommonSubstr(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         int[][][] dp = new int[m][n][Math.max(m, n)]; // DP array

//         for (int[][] row : dp) {
//             for (int[] col : row) {
//                 Arrays.fill(col, -1);
//             }
//         }

//         return solve(s1, s2, m - 1, n - 1, 0, dp);
//     }

//     private int solve(String s1, String s2, int m, int n, int count, int dp[][][]) {
//         if (m < 0 || n < 0) return count; // Return count if one string is exhausted

//         if (dp[m][n][count] != -1) return dp[m][n][count];

//         int newCount = count;
//         if (s1.charAt(m) == s2.charAt(n)) {
//             newCount = solve(s1, s2, m - 1, n - 1, count + 1, dp); // Increase count
//         }

//         return dp[m][n][count] = Math.max(newCount, Math.max(solve(s1, s2, m - 1, n, 0, dp), solve(s1, s2, m, n - 1, 0, dp)));
//     }
// }


class Solution {
    public int longestCommonSubstr(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        int m=text1.length();
        int n=text2.length();
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}

