class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        finding(nums,0,hs,arr);
        for(List<Integer> ls:hs)
        {
            ans.add(ls);
        }
        return ans;
    }
    private void finding(int[] nums,int index,HashSet<List<Integer>> hs,List<Integer> arr)
    {
        if(index==nums.length)
        {
            hs.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[index]);
        finding(nums,index+1,hs,arr);
        arr.remove(arr.size()-1);
        finding(nums,index+1,hs,arr);
    }
}