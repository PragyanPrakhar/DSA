class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(0);
        for(int i:cuts){
            arr.add(i);
        }
        arr.add(n);
        Collections.sort(arr);
        int dp[][]=new int[cuts.length+1][cuts.length+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(1,cuts.length,arr,dp);
    }
    private int solve(int i,int j,ArrayList<Integer> arr,int dp[][]){
        if(i>j) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            mini=Math.min(mini,((arr.get(j+1)-arr.get(i-1))+solve(i,ind-1,arr,dp)+solve(ind+1,j,arr,dp)));
        }
        return dp[i][j]=mini;
    }
}