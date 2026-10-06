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

    public void remove(TreeNode root, int tar) {
        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                if (root.right.val == tar) {
                    root.right = null;
                }
            } else {
                remove(root.right, tar);
                if (root.right.left == null && root.right.right == null) {
                    if (root.right.val == tar) {
                        root.right = null;
                    }
                }
            }
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                if (root.left.val == tar) {
                    root.left = null;
                }
            } else {
                remove(root.left, tar);
                if (root.left.left == null && root.left.right == null) {
                    if (root.left.val == tar) {
                        root.left = null;
                    }
                }
            }
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode head = new TreeNode(target + 1);
        head.right = root;
        remove(head, target);
        return head.right;
    }
}
