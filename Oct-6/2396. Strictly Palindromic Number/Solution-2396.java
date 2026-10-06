class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            int t = n;
            List<Integer> lst = new ArrayList<>();
            while (t != 0) {
                int f = t % i;
                lst.add(f);
                t = t / i;
            }
            int len = lst.size();
            for (int j = 0, k = len - 1; j < k; j++, k--) {
                if (lst.get(j) != lst.get(k)) {
                    return false;
                }
            }
        }
        return true;
    }
}
