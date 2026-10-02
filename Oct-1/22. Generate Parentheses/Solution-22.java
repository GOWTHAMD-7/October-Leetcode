class Solution {
    public void backtrack(List<String> ret, int open, int close, int len, StringBuilder str) {
        if (str.length() == len * 2) {
            ret.add(new String(str));
        } else if (open > close && open < len) {
            str.append("(");
            open++;
            backtrack(ret,open, close, len, str);
            str.deleteCharAt(str.length() - 1);
            open--;
            str.append(")");
            close++;
            backtrack(ret,open, close, len, str);
            str.deleteCharAt(str.length() - 1);
        } else if (open > close && open == len) {
            str.append(")");
            close++;
            backtrack(ret,open, close, len, str);
            str.deleteCharAt(str.length() - 1);
        } else if (open == close && open < len) {
            str.append("(");
            open++;
            backtrack(ret,open, close, len, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder("");
        List<String> ret = new ArrayList<>();
        backtrack(ret, 0, 0, n, str);
        return ret;
    }
}
