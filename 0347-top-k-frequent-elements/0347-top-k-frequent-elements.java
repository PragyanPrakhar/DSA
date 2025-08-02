class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums) hm.put(num,hm.getOrDefault(num,0)+1);
        List<Integer>[] bucket=new List[nums.length+1];
        for(int num:hm.keySet()){
            int freq=hm.get(num);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                ans.addAll(bucket[i]);
            }
        }
        int res[]=new int[k];

        for(int i=0;i<k; i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}