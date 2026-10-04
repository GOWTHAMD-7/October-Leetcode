class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        int len = arr.length;
        int k = len - 1;
        while (k >= 0) {
            int max = -1;
            int pos = 0;
            for (int i = 0; i <= k; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    pos = i;
                }
            }
            if (pos == k) {
                k--;
            } else if (pos == 0) {
                ret.add(k + 1);
                for (int i = 0, j = k; i < j; i++, j--) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                k--;
            } else {
                ret.add(pos + 1);
                for (int i = 0, j = pos; i < j; i++, j--) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                ret.add(k + 1);
                for (int i = 0, j = k; i < j; i++, j--) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                k--;
            }
        }
        return ret;
    }
}
