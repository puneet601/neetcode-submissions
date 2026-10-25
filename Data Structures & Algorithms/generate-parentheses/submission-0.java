class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    void dfs(int n, int open, int closed, StringBuilder curr, List<String> res) {
        if (closed == n) {
            res.add(curr.toString());
        }

        if (open > n || closed > n)
            return;

        if (open < n) {
            curr.append("(");
            dfs(n, open + 1, closed, curr, res);
            curr.deleteCharAt(curr.length() - 1);
            
        }

        if (open > closed) {
                curr.append(")");
                dfs(n, open, closed + 1, curr, res);
                 curr.deleteCharAt(curr.length() - 1);
            }
    }
}
