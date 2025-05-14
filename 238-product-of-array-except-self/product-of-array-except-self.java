class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int lp[]=new int[nums.length];
        int rp[]=new int[nums.length];
        lp[0]=nums[0];
        rp[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            lp[i]=nums[i]*lp[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rp[i]=rp[i+1]*nums[i];
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                ans[i]=rp[i+1];
            }
            else if(i==n-1){
                ans[i]=lp[i-1];
            }
            else{
                ans[i]=lp[i-1]*rp[i+1];
            }
        }
        return ans;
    }
}