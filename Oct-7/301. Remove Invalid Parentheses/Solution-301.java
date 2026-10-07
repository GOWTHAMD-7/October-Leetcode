class Solution {

    public boolean valid(StringBuilder sb) {
        int len = sb.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == '(') {
                cnt++;
            } else if (sb.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return (cnt == 0) ? true : false;
    }

    public void remove(String s, StringBuilder sb, int pos, int open, int close, HashSet<String> set) {
        int len = s.length();
        if (pos == len) {
            if (valid(sb)) {
                String t = sb.toString();
                set.add(t);
            }
            return;
        }
        if (s.charAt(pos) == '(') {
            remove(s, sb, pos + 1, open, close, set);
            open++;
            sb.append('(');
            remove(s, sb, pos + 1, open, close, set);
            sb.deleteCharAt(sb.length() - 1);
        } else if (s.charAt(pos) == ')') {
            remove(s, sb, pos + 1, open, close, set);
            close++;
            if (close > open) {
                return;
            }
            sb.append(')');
            remove(s, sb, pos + 1, open, close, set);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(s.charAt(pos));
            remove(s, sb, pos + 1, open, close, set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        remove(s, sb, 0, 0, 0, set);
        List<String> ret = new ArrayList<>();
        int max = -1;
        for (String t : set) {
            int len = t.length();
            if (len > max) {
                max = len;
                ret.clear();
                ret.add(t);
            } else if (len == max) {
                ret.add(t);
            }
        }
        
        return ret;
    }
}
