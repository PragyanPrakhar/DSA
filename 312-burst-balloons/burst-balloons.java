class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        arr.add(1);
        for (int i : nums) {
            arr.add(i);
        }
        arr.add(1);
        return solve(1, arr.size() - 2, arr, dp);
    }

    private int solve(int i, int j, ArrayList<Integer> arr, int dp[][] ) {
        if (i > j)
            return 0;
        int maxi=Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            maxi=Math.max(maxi,(arr.get(i-1)*arr.get(ind)*arr.get(j+1)+solve(i,ind-1,arr,dp)+solve(ind+1,j,arr,dp)));
        }
        return dp[i][j]=maxi;

    }
}