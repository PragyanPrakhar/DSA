class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recurr(ans,candidates,target,0,temp,0);
        return ans;
    }
    private void recurr(List<List<Integer>> ans , int candidates[] , int target , int sum , List<Integer> temp , int index){
        if(sum>target) return;
        if(index==candidates.length){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(target==sum){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[index]);
        recurr(ans,candidates,target,sum+candidates[index],temp,index);
        temp.remove(temp.size()-1);
        recurr(ans,candidates,target,sum,temp,index+1);
    }
}