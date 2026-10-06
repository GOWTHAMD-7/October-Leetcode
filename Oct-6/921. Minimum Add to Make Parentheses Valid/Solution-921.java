class Solution {
    public int minAddToMakeValid(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    st.push(')');
                } else if (st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }
}
