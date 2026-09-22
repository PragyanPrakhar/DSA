class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int mA=0;
        while(i<j){
            if(height[i]<height[j]){
                mA=Math.max(((j-i)*Math.min(height[i],height[j])),mA);
                i++;
            }
            else{
                mA=Math.max(((j-i)*Math.min(height[i],height[j])),mA);
                j--;
            }
        }
        return mA;
    }
}