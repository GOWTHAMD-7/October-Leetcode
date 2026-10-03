import java.util.*;

class Solution {

    public int longestStrChain(String[] words) {
        int len = words.length;
        int max = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String s = words[i];
            int slen = s.length();
            int cnt = 1;

            for (int j = 0; j < slen; j++) {
                String t = s.substring(0, j) + s.substring(j + 1);

                if (map.containsKey(t)) {
                    cnt = Math.max(cnt, map.get(t) + 1);
                }
            }

            map.put(s, cnt);
            max = Math.max(max, cnt);
        }
        return max;
    }
}
