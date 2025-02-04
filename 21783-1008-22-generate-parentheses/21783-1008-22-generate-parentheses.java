class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int open=0;
        int close=0;
        String temp="";
        generateParanthesis(n,open,close,temp,ans);
        return ans;
    }
    private void generateParanthesis(int n,int open,int close,String temp,List<String> ans)
    {
        if(open==n && close==n)
        {
            ans.add(temp);
        }
        if(open>n || close>open)
        {
            return;
        }
        generateParanthesis(n,open+1,close,temp+"(",ans);
        generateParanthesis(n,open,close+1,temp+")",ans);

    }
}