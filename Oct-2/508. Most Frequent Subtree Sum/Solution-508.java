/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int max = -1;
    
    public int freq(TreeNode root, HashMap<Integer, Integer> map) {
        if (root.left != null && root.right != null) {
            int sum = root.val;
            sum += freq(root.left, map);
            sum += freq(root.right, map);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
            return sum;
        } else if (root.left == null && root.right != null) {
            int sum = root.val;
            sum += freq(root.right, map);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
            return sum;
        } else if (root.left != null && root.right == null) {
            int sum = root.val;
            sum += freq(root.left, map);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
            return sum;
        } else {
            int sum = root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
            return sum;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int t = freq(root, map);
        List<Integer> lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                lst.add(entry.getKey());
            }
        }
        int[] ret = new int[lst.size()];
        int k = 0;
        for (int i : lst) {
            ret[k] = i;
            k++;
        }
        return ret;        
    }
}
