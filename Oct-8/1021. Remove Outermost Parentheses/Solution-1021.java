class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int cnt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    sb.append(s.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }
}
