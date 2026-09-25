class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // Using Kdane's Algorithm
        int best=values[0]+0;
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<values.length;i++){
            ans=Math.max(ans,best+values[i]-i);
            best=Math.max(best,values[i]+i);
        }
        return ans;
    }
}