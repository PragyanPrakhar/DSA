class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans=0;
        ArrayList<Integer> original=new ArrayList();
        for(int num:nums){
            original.add(num);
        }
        while(true){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=0;i<original.size()-1;i++){
                arr.add((original.get(i)+original.get(i+1))%10);
            }
            if(arr.size() == 1){
                ans=arr.get(0);
                break;
            }
            original=arr;
        }
        return ans;
    }
}