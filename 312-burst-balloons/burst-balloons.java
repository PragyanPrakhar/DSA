class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int dp[][]=new int[nums.length+2][nums.length+2];
        arr.add(1);
        for (int i : nums) {
            arr.add(i);
        }
        arr.add(1);

        // Tabulation Approach -> Bottom Up.
        for(int i=nums.length;i>=1;i--){
            for(int j=i;j<=nums.length;j++){
                // if(i>j) continue;
                int maxi=Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int temp=arr.get(i-1)*arr.get(ind)*arr.get(j+1)+dp[i][ind-1]+dp[ind+1][j];
                    maxi=Math.max(maxi,temp);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][nums.length];
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