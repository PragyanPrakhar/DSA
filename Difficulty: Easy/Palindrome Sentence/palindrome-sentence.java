class Solution {
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            // if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        StringBuilder sb1=new StringBuilder();
        sb1.append(sb);
        return sb.reverse().toString().equals(sb1.toString());
    }
}