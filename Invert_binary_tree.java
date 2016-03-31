/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
            if(root == null)
                return root;
         TreeNode p = root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        p.left = r;
        p.right =l;
        return p;
        
    }
}