package Leetecode;

/**
 * Created by qinjiawei on 16-12-17.
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * 236
     * 寻找最近的祖先
     *我们可以用深度优先搜索，从叶子节点向上，标记子树中出现目标节点的情况。如果子树中有目标节点，标记为那个目标节点，如果没有，标记为null。显然，如果左子树、右子树都有标记，说明就已经找到最小公共祖先了。如果在根节点为p的左右子树中找p、q的公共祖先，则必定是p本身。

     换个角度，可以这么想：如果一个节点左子树有两个目标节点中的一个，右子树没有，那这个节点肯定不是最小公共祖先。如果一个节点右子树有两个目标节点中的一个，左子树没有，那这个节点肯定也不是最小公共祖先。只有一个节点正好左子树有，右子树也有的时候，才是最小公共祖先。

     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 当该节点已经寻找到了两个目标节点，那么就是这个了
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //该节点的两个子树中都标记了
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        else if(right != null)
            return right;

        return null;
    }
}
