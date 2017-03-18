package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-12.
 */
public class BinaryTreeInorderTraversal {

    /**
     * 94
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
//        dfs(root, ret);
        QueueMethod(root, ret);
        return ret;
    }

    /**
     * 递归的实现
     * @param root
     * @param ans
     */
    public void dfs(TreeNode root, List<Integer> ans)
    {
        if(root== null)
            return;
        if(root.left != null)
            dfs(root.left, ans);
        ans.add(root.val);
        if (root.right != null)
            dfs(root.right, ans);

    }

    /**
     * 非递归的实现   栈的思想
     * @param root
     * @param ans
     */
    public void QueueMethod(TreeNode root, List<Integer> ans)
    {
        Stack<TreeNode> queue = new Stack<>();

//        queue.push(root);
        while (!queue.isEmpty() || root != null)
        {


            while (root!= null)
            {
                queue.push(root);
                root = root.left;
            }

            TreeNode node = queue.pop();
            ans.add(node.val);
            root = node.right;
            //if(root != null)
            //   queue.push(root);
        }

    }
    public static void  main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        b.inorderTraversal(root);
    }


}
