package Leetecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qinjiawei on 16-12-12.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root== null)
            return ans;

        contruct(root, ans);
        return ans;
    }

    public void contruct(TreeNode root, List<Integer> ans)
    {
        if (root == null)
            return;
        ans.add(root.val);
        if(root.left != null)
            contruct(root.left, ans);
        if (root.right != null)
            contruct(root.right, ans);

    }

    /**
     * 非递归调用方法
     * 栈的思想
     * @param root
     * @param ans
     */
    public  void  NoContruct(TreeNode root, List<Integer> ans)
    {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
    }
}
