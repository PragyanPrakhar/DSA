class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int evenIndex=0;
        int oddIndex=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                ans[evenIndex]=nums[i];
                evenIndex+=2;
            }
            else{
                ans[oddIndex]=nums[i];
                oddIndex+=2;
            }
        }
        return ans;
    }
}