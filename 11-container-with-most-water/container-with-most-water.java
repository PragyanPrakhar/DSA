class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int area=0;
        while(i<j)
        {
            int currentArea=Math.min(height[i],height[j])*(j-i);
            area=Math.max(area,currentArea);

            if(height[i]>height[j])
            {
                j--;
            }
            else 
            {
                i++;
            }
        }
        return area;
        
    }
}