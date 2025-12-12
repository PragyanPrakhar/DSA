class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pProduct[]=new int[nums.length];
        int sProduct[]=new int[nums.length];
        pProduct[0]=1;
        sProduct[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            pProduct[i]=pProduct[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            sProduct[i]=sProduct[i+1]*nums[i+1];
        }

        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=pProduct[i]*sProduct[i];
        }
        return ans;
    }
}