class Solution {
    public int titleToNumber(String columnTitle) {
        int num=26;
        int temp=columnTitle.length()-1;
        int ans=1;
        for(int i=0;i<columnTitle.length();i++)
        {
            ans+=((int)columnTitle.charAt(i)-'A'+1)*((int)Math.pow(26,temp--));
        }
        return ans-1;

    }
}