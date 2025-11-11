class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(n,ans,0,0,"");
        return ans;
    }

    private void generate(int n,List<String> ans,int open,int close,String s){
        if(open==n && close==n){
            ans.add(s);
            return;
        }

        if(close > open) return;
        if(open>n || close>n) return;

        generate(n,ans,open+1,close,s+"(");
        generate(n,ans,open,close+1,s+")");


    }

}