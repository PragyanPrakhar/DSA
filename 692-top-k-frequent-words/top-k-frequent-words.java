class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String word:words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        List<String>[] bucket=new List[words.length+1];
        for(String word:hm.keySet()){
            int freq=hm.get(word);
            if(bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(word);
        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=bucket.length-1;i>=0 && ans.size()<k;i--){
            if(bucket[i]!=null){
                // ans.addAll(bucket[i]);
                Collections.sort(bucket[i]);
                for(String word:bucket[i]){
                    if(ans.size()<k) ans.add(word);
                }
            }
        }
        return ans;
    }
}