package Leetecode;

/**
 * Created by qinjiawei on 16-12-6.
 */
public class SumRoottoLeafNumbers {

    /**
     * 129	Sum Root to Leaf Numbers
     * 最基本的深度优先遍历
     */
    public int sum =0;
    public int sumNumbers(TreeNode root) {

        if(root == null)
            return sum;

        ContactSum(root, 0);
        return sum;

    }
    public void ContactSum(TreeNode root, int curvalue)
    {
        if(root.left == null&& root.right == null)
        {
            sum += curvalue *10 + root.val;
        }
        else {
            if(root.left != null)
                ContactSum(root.left, curvalue * 10 + root.val);
            if(root.right != null)
                ContactSum(root.right, curvalue *10 + root.val);
        }
    }
}
