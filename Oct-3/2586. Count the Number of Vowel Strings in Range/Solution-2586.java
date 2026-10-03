class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int len = words.length;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ret = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1))) {
                ret++;
            }
        }
        return ret;
    }
}
