class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        // HashMap<Character,Integer> hm=new HashMap<>();
        int freqS1[]=new int[26];
        int freqS2[]=new int[26];

        for (char ch:s1.toCharArray()){
            freqS1[ch-'a']++;
        }

        for(int i=0;i<s1.length();i++){
            freqS2[s2.charAt(i)-'a']++;
        }

        for(int i=s1.length();i<s2.length();i++){
            if(isEqual(freqS1,freqS2)) return true;
            freqS2[s2.charAt(i)-'a']++;
            freqS2[s2.charAt(i-s1.length())-'a']--;
        }
        return isEqual(freqS1,freqS2);
    }

    private boolean isEqual(int freqS1[],int freqS2[]){
        for(int i=0;i<26;i++){
            if(freqS1[i]!=freqS2[i]) return false;
        }
        return true;
    }
    
}