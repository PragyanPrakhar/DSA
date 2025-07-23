class Solution {
    public int maximumGain(String s, int x, int y) {
        int n=s.length();
        int greater=(x>=y)?x:y;
        int smaller=(x+y)-greater;
        String toBeRemoved= (x>=y) ? "ab" : "ba";
        StringBuilder sb=new StringBuilder();
        char c=toBeRemoved.charAt(1);
        sb.append(s);
        int maxScore=0;
        for(int i=0;i<sb.length();){
            if(sb.charAt(i)==c && i>0){
                if(sb.charAt(i-1)==toBeRemoved.charAt(0)){
                    maxScore+=greater;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i-1);
                    i = Math.max(0, i - 2);
                }
                else{
                    i++;
                }
            }
            else i++;
        }
        String secondPair = (x >= y) ? "ba" : "ab";
        for(int i=0;i<sb.length();){
            if(sb.charAt(i)==secondPair.charAt(1) && i>0){
                if(sb.charAt(i-1)==secondPair.charAt(0)){
                    maxScore+=smaller;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i-1);
                    i = Math.max(0, i - 2);
                }
                else{
                    i++;
                }
            }
            else i++;
        }
        return maxScore;
    }
}
// Just modify my this approach only