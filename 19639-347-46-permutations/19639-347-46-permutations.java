class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] freq = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        findingPermutations(nums, ans, freq, 0, ds);
        return ans;
    }

    private void findingPermutations(int[] nums, List<List<Integer>> ans, boolean[] freq, int ind,
            ArrayList<Integer> ds) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!freq[i])
            {
                freq[i]=true;
                ds.add(nums[i]);
                findingPermutations(nums,ans,freq,ind+1,ds);
                ds.remove(ds.size()-1);
                freq[i]=false;

            }
        }

    }
}