class Solution {
    public int countGoodSubstrings(String s) {
        int totalCount=0;
        for(int i=2;i<s.length();i++){
            if((s.charAt(i)!=s.charAt(i-1)) && (s.charAt(i)!=s.charAt(i-2)) && (s.charAt(i-1)!=s.charAt(i-2))){
                totalCount++;
            }
        }
        return totalCount;
    }
}