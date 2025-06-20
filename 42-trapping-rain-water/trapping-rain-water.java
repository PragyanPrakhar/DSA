class Solution {
    public int trap(int[] height) {
        int lMax[]=new int[height.length];
        int rMax[]=new int[height.length];
        int n=height.length;
        lMax[0]=height[0];
        rMax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            lMax[i]=Math.max(lMax[i-1],height[i]);
        }
        for(int j=n-2;j>=0;j--){
            rMax[j]=Math.max(rMax[j+1],height[j]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+= Math.min(lMax[i],rMax[i])-height[i];
        }
        return ans;
    }
}