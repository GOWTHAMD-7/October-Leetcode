class Solution {
    public int passwordStrength(String s) {
        int len = s.length();
        int ret = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            if (c >= 48 && c <= 57) {
                ret += 3;
            } else if (c >= 65 && c <= 92) {
                ret += 2;
            } else if (c >= 97 && c <= 122) {
                ret += 1;
            } else {
                ret += 5;
            }
        }
        return ret;
    }
}
