class Solution {
    public int minRotations(String s) {
        int len = s.length();
        int prev = Integer.valueOf(s.substring(0, 1));
        int cnt = Math.min(prev, 10 - prev);
        for (int i = 1; i < len; i++) {
            int next = Integer.valueOf(s.substring(i, i + 1));
            if (prev < next) {
                int x = next - prev;
                int y = prev + (10 - next);
                cnt += Math.min(x, y);
            } else {
                int x = prev - next;
                int y = next + (10 - prev);
                cnt += Math.min(x, y);
            }
            prev = next;
        }
        return cnt;
    }
}
