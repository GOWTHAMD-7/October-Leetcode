class Solution {
    public String stringHash(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = k; i <= len; i += k) {
            int sum = 0;
            for (int j = i - k; j < i; j++) {
                sum += (s.charAt(j) - 'a');
            }
            sum = sum % 26;
            sb.append((char) (sum + 'a'));
        }
        return sb.toString();
    }
}
