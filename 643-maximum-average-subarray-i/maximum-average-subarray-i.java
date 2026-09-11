class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg=-Double.MAX_VALUE;
        int start=0;
        int end=0;
        double currentWindowSum=0;
        while(end < nums.length){
            currentWindowSum += nums[end];
            if(end-start+1 == k){
                maxAvg = (currentWindowSum/k > maxAvg) ? currentWindowSum/k : maxAvg;
            }
            if(end-start+1 > k){
                currentWindowSum = currentWindowSum - nums[end-k];
                 maxAvg = (currentWindowSum/k > maxAvg) ? currentWindowSum/k : maxAvg;
                start++;
            }
            end++;
        }
        return maxAvg;
    }
}