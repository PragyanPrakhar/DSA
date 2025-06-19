class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets=new List[nums.length+1];
        for(int key:hm.keySet()){
            int freq=hm.get(key);
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> result=new ArrayList<>();
        for(int i=buckets.length-1;i>=0 && result.size()<k ;i--){
            if(buckets[i]!=null){
                result.addAll(buckets[i]);
            }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}