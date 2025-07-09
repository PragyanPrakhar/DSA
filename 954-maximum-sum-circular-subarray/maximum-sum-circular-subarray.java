class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int non_wrapperSum=kdanes(nums);
        boolean isAllNegative=checkNegative(nums);
        if(isAllNegative){
            int max=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]>max) max=nums[i];
            }
            return max;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=-nums[i];
        }
        int wrapper_sum=sum+kdanes(nums);
        return Math.max(non_wrapperSum,wrapper_sum);
    }
    private boolean checkNegative(int nums[]){
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0) return false;
        }
        return true;
    }
    private int kdanes(int nums[]){
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            cs+=nums[i];
            ms=Math.max(ms,cs);
            if(cs<0){
                cs=0;
            }
        }
        return ms;
    }
}