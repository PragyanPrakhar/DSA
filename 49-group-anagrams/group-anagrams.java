class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char chArray[]=strs[i].toCharArray();
            Arrays.sort(chArray);
            String wd=new String(chArray);
            if(!hm.containsKey(wd)){
                hm.put(wd,new ArrayList<>());
            }
            hm.get(wd).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}