class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        int i=0;
        int j=sb.length()-1;
        while(i<=j){
            if(sb.charAt(i)==sb.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}