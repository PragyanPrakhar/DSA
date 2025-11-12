class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> hs=new HashSet<>();
        List<Integer> ls=new ArrayList<>();
        recurr(candidates,target,0,0,hs,ls);
        List<List<Integer>> ans=new ArrayList<>();
        for(List<Integer> lss:hs){
            ans.add(lss);
        }
        return ans;

        
    }
    private void recurr(int candidates[],int target,int sum,int idx,HashSet<List<Integer>> uniques,List<Integer> ls){
        if(idx>=candidates.length) return;
        if(sum > target) return;
        // if(idx == candidates.length-1){
        //     if(sum==target) uniques.add(new ArrayList<>(ls));
        //     return;
        // }

        if(sum==target){
            uniques.add(new ArrayList<>(ls));
            return;
        }

        ls.add(candidates[idx]);
        recurr(candidates,target,sum+candidates[idx],idx,uniques,ls);
        ls.remove(ls.size()-1);
        recurr(candidates,target,sum,idx+1,uniques,ls);
    }
}