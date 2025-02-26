class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        // for(int[] ar:dp) Arrays.fill(ar,-1);
        //Tabulation Approach
        //Writing the base case
        int m=word1.length();
        int n=word2.length();
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int insert=1+dp[i][j-1];
                    int replace=1+dp[i-1][j-1];
                    int delete=1+dp[i-1][j];
                    dp[i][j]=Math.min(insert,Math.min(replace,delete));
                }
            }
        }
        return dp[word1.length()][word2.length()];


        // return solve(word1, word2, word1.length(), word2.length(),dp);
    }

    // Memoization Approach
    // private int solve(String word1, String word2, int m, int n, int dp[][]) {
    //     if (m == 0)
    //         return n;
    //     if (n == 0)
    //         return m;
    //     if (dp[m][n] != -1)
    //         return dp[m][n];
    //     if (word1.charAt(m - 1) == word2.charAt(n - 1))
    //         return solve(word1, word2, m - 1, n - 1, dp);
    //     int delete = 1 + solve(word1, word2, m - 1, n, dp);
    //     int replace = 1 + solve(word1, word2, m - 1, n - 1, dp);
    //     int insert = 1 + solve(word1, word2, m, n - 1, dp);
    //     return dp[m][n] = Math.min(delete, Math.min(replace, insert));
    // }
}