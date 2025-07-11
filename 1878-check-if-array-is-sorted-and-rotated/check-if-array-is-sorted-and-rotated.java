class Solution {
    public boolean check(int[] nums) {
        int count=0;
        int ele=-1;
        int idx=-1;
        for(int i=0;i<nums.length-1;i++){
            if(count>1) return false;
            if(nums[i]>nums[i+1]){
                count++;
                if(ele == -1){
                    ele=nums[i];
                    idx=i;
                }
            }
        }
        int valToBeChecked=nums[nums.length-1];
        for(int i=0;i<idx;i++){
            if(valToBeChecked>nums[i]) return false;
        }
        if(count>0 && ele<nums[nums.length-1]) return false;
        return (count==1 || count==0);
    }
}