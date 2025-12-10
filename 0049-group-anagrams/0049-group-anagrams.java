class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sortedString=new String(ch);
            System.out.println(sortedString);
            if(hm.containsKey(sortedString)){
                hm.get(sortedString).add(str);
            }
            else{
                List<String> newList=new ArrayList<>();
                newList.add(str);
                // hm.put(sortedString, newList);
                hm.put(sortedString,newList);
            }
        }
        for(List<String> ls:hm.values()){
           ans.add(ls);
        }
        return ans;
        
    }
}