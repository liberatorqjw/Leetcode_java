package Leetecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qinjiawei on 16-12-12.
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null)
           return ans;

        conctruct(root, ans);
        return ans;

    }

    /**
     * 递归的方法
     * @param root
     * @param ans
     */
    public void  conctruct(TreeNode root, List<Integer> ans)
    {
        if (root.left != null)
            conctruct(root.left, ans);
        if(root.right != null)
            conctruct(root.right, ans);
        ans.add(root.val);

    }

    /**
     * 非递归的方法
     * 后续遍历输出的两个条件
     * 1. 自己本身是叶子节点
     * 2. 它的孩子节点已经输出过了, 所以需要记录一下，当前的输出节点
     * @param root
     * @param ans
     */
    public void conctructTree(TreeNode root, List<Integer> ans)
    {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode head = root;

        while (!stack.isEmpty())
        {
            TreeNode cur = stack.peek();

            //当前节点的孩子节点已经遍历过了                   叶子节点
            if(cur.left == head || cur.right == head || (cur.left == null && cur.right == null))
            {
                ans.add(cur.val);
                stack.pop();
                head = cur;
            }

            //注意一定加上esle 就是当前节点输出了就不要再加进来了

            else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }
}
