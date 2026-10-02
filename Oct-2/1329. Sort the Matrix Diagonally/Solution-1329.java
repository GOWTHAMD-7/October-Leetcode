class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int k = 0; k < m; k++) {
            PriorityQueue<Integer> lst = new PriorityQueue<>();
            int i = k;
            int j = 0;
            while (i < m && j < n) {
                lst.add(mat[i][j]);
                i++;
                j++;
            }
            i = k;
            j = 0;
            while (i < m && j < n) {
                mat[i][j] = lst.poll();
                i++;
                j++;
            }
        }
        for (int k = 0; k < n; k++) {
            PriorityQueue<Integer> lst = new PriorityQueue<>();
            int i = 0;
            int j = k;
            while (i < m && j < n) {
                lst.add(mat[i][j]);
                i++;
                j++;
            }
            i = 0;
            j = k;
            while (i < m && j < n) {
                mat[i][j] = lst.poll();
                i++;
                j++;
            }
        }
        return mat;
    }
}
