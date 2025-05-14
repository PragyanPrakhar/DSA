class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currentSum=0;
        int maximumSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currentSum+=nums[i];
            if(currentSum>maximumSum){
                maximumSum=currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maximumSum;
    }
}