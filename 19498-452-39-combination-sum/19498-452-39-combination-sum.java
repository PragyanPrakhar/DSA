class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        finding(candidates, target, candidates.length - 1, hs, ans,new ArrayList<>());
        return ans;
    }

    void finding(int[] candidates, int target, int index, HashSet<List<Integer>> hs, List<List<Integer>> ans,List<Integer> arr) {
        if(index<0)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(arr));
            }
            // else
            // {
                return;
            // }
        }
        if(candidates[index]<=target)
        {
            arr.add(candidates[index]);
            finding(candidates,target-candidates[index],index,hs,ans,arr);
            arr.remove(arr.size()-1);
        }            
        finding(candidates,target,index-1,hs,ans,arr);


    }
}