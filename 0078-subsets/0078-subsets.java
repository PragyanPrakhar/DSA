class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        findingSubsets(nums,ans,0,arr);
        return ans;
    }
    private void findingSubsets(int nums[],List<List<Integer>> ans,int index,ArrayList<Integer> arr){
        if(index==nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        //take
        arr.add(nums[index]);
        findingSubsets(nums,ans,index+1,arr);
        //not take
        arr.remove(arr.size()-1);
        findingSubsets(nums,ans,index+1,arr);
    }
}