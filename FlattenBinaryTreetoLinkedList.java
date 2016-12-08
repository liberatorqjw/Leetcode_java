package Leetecode;

/**
 * Created by qinjiawei on 16-12-7.
 */
public class FlattenBinaryTreetoLinkedList {
    /**
     * 114
     * 应该是前序遍历然后构建一棵树
     */
    public void flatten(TreeNode root) {

        if (root == null)
            return;

        constructTree(root);

    }

    public TreeNode constructTree(TreeNode root)
    {
        if(root == null)
            return null;

        if(root.left == null && root.right == null)
            return root;
        else
        {
            // 保证后续的改变不会影响到本身的结构
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            if (left != null) {
                root.right = left;
                TreeNode tmp = constructTree(left);
                tmp.left = null;
                if(right != null)
                {
                    tmp.right = right;
                }
                else {
                    return tmp;
                }
            }
            return constructTree(right);

        }
    }


    public static void  main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = root.left.left.right = null;
        root.left.right.left = root.left.right.right = null;

        root.right.right = new TreeNode(6);
        root.right.left = null;
        FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
        f.flatten(root);
    }
}
