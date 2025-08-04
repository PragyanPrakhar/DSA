// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        HashSet<ArrayList<Integer>> ans=new HashSet<>();
        for(int num:arr){
            if(hs.contains(-num)){
                int firstOne= -num>0 ? num : -num;
                int secondOne= -num>0 ? -num : num;
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(firstOne);
                temp.add(secondOne);
                ans.add(temp);
                hs.remove(-num);
            }
            else{
                hs.add(num);
            }
        }
        // Collections.sort(ans);
        ArrayList<ArrayList<Integer>> finalAns=new ArrayList<>();
        for(ArrayList<Integer> ai:ans){
            finalAns.add(ai);
        }
        Collections.sort(finalAns, (a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });
        return finalAns;
    }
}
