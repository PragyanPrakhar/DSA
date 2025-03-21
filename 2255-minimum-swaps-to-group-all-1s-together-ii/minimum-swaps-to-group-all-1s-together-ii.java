class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[] = new int[2*n];
        for(int i=0;i<(2*n);i++){
            arr[i]=nums[i%n];
        }
        int windowSize = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                windowSize++;
            }
        }
        if(windowSize==0 || windowSize==n){
            return 0;
        }
        int minSwaps = 0;
        for(int i=0;i<windowSize;i++){
            if(nums[i]==0){
                minSwaps++;
            }
        }
        int ans=minSwaps;
        for(int i=windowSize;i<(n+windowSize);i++){
            if(arr[i]==0){
                minSwaps++;
            }
            if(arr[i-windowSize]==0){
                minSwaps--;
            }
            ans=Math.min(ans,minSwaps);
        }
        return ans;
    }
}