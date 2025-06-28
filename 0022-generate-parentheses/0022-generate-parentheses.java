class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", ans);
        return ans;
    }

    private void generateParenthesis(int n, int open, int close, String temp, List<String> ans) {
        if (open == n && close == n) {
            ans.add(temp);
            return;
        }

        if (open < n) {
            generateParenthesis(n, open + 1, close, temp + "(", ans);
        }

        if (close < open) {
            generateParenthesis(n, open, close + 1, temp + ")", ans);
        }
    }
}
