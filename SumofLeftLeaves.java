package Leetecode;

/**
 * Created by qinjiawei on 16-12-13.
 */
public class SumofLeftLeaves {
    /**
     * 404
     * 寻找左边叶子节点的和，那么就是递归的方法，只是加个标记是不是左叶子节点
     */
    public int sumOfLeftLeaves(TreeNode root) {

        int ans = 0;
        if (root == null)
            return  ans;

        return construct(root, ans, false);

    }

    public int construct(TreeNode root, int ans, boolean flag)
    {
        if(root.left == null && root.right == null && flag)
            return ans += root.val;

        if(root.left != null)
            ans +=construct(root.left, ans, true);
        if (root.right != null)
            ans +=construct(root.right, ans, false);

        return  ans;
    }
}
