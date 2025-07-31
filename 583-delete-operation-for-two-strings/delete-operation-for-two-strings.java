class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        int i=n;
        int j=m;
        return find(i,j,word1,word2,dp);    
    }
    private int find(int i,int j,String word1,String word2,int dp[][])
    {
        if(i==0 || j==0) return dp[i][j]=i+j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            return find(i-1,j-1,word1,word2,dp);
        }
        return dp[i][j]=Math.min(find(i-1,j,word1,word2,dp),find(i,j-1,word1,word2,dp))+1;
    }
}