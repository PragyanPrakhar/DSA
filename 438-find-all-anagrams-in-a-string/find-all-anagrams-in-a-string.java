class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(p.length()>s.length()) return ans;

        int freqS[]=new int[26];
        int freqP[]=new int[26];

        for(char ch:p.toCharArray()){
            freqP[ch-'a']++;
        }

        for(int i=0;i<p.length();i++){
            freqS[s.charAt(i)-'a']++;
        }

        for(int i=p.length();i<s.length();i++){
            if(isEqual(freqS,freqP)) {
                ans.add(i-p.length());
            }
            freqS[s.charAt(i)-'a']++;
            freqS[s.charAt(i-p.length())-'a']--;
        }
        if(isEqual(freqS,freqP)){
            ans.add(s.length()-p.length());
        }
        return ans;
    }

    private boolean isEqual(int freqS[],int freqP[]){
        for(int i=0;i<26;i++){
            if(freqS[i]!=freqP[i]){
                return false;
            }
        }
        return true;
    }
}