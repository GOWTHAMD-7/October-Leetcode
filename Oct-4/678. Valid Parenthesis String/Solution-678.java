class Solution {

    public int check(String s, int pos, int cnt, int[][] dp) {
        int len = s.length();
        if (pos == len) {
            if (cnt == 0) {
                return 2;
            } else {
                return 1;
            }
        }
        if (s.charAt(pos) == '(') {
            if (dp[pos][cnt] != 0) {
                return dp[pos][cnt];
            }
            int t = check(s, pos + 1, cnt + 1, dp);
            dp[pos][cnt] = t;
            return t;

        } else if (s.charAt(pos) == ')') {
            if (dp[pos][cnt] != 0) {
                return dp[pos][cnt];
            }
            if (cnt == 0) {
                dp[pos][cnt] = 1;
                return 1;
            }
            int t = check(s, pos + 1, cnt - 1, dp);
            dp[pos][cnt] = t;
            return t;
        } else {
            int a = 1;
            int b = 1;
            int c = 1;
            if (dp[pos][cnt] != 0) {
                return dp[pos][cnt];
            }
            a = check(s, pos + 1, cnt + 1, dp);
            if (a == 2) {
                dp[pos][cnt] = 2;
                return 2;
            }
            if (cnt != 0) {
                b = check(s, pos + 1, cnt - 1, dp);
                if (b == 2) {
                    dp[pos][cnt] = 2;
                    return 2;
                }
            }
            c = check(s, pos + 1, cnt, dp);
            if (c == 2) {
                dp[pos][cnt] = 2;
                return 2;
            }
            dp[pos][cnt] = 1;
            return 1;
        }
    }

    public boolean checkValidString(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int ret = check(s, 0, 0, dp);
        return ret == 2 ? true : false;
    }
}
