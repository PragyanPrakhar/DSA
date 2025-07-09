class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets=new List[nums.length+1];
        for(int num:hm.keySet()){
            int freq=hm.get(num);
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=buckets.length-1;i>=0 && ans.size()<k;i--){
            if(buckets[i]!=null){
                ans.addAll(buckets[i]);
            }
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}