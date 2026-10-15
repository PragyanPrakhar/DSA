class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate(res,n,"",0,0);
        return res;
    }
    void generate(List<String> res , int n , String temp , int open , int closed){
        if(open == n && closed == n){
            res.add(temp);
            return;
        }
        if(closed > open) return;
        if(open > n || closed > n) return;

        generate(res,n,temp+"(",open+1,closed);
        generate(res,n,temp+")",open,closed+1);
    }
}