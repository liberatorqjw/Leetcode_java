package Leetecode;

/**
 * Created by qinjiawei on 16-12-16.
 */
public class DeleteNodeinaBST {

    /**
     * 450
     * 删除节点是比较复杂的情况
     * 分三种情况：没有孩子，只有一个孩子，有两个孩子。
     没有孩子的情况，其父结点指向空，删除该结点。
     有一个孩子的情况，其父结点指向其孩子，删除该结点。
     有两个孩子的情况，当前结点与左子树中最大的元素交换，然后删除当前结点。左子树最大的元素一定是叶子结点，交换后，当前结点即为叶子结点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return root;

        TreeNode partent = null;
        TreeNode newTree = root;

        while (root != null)
        {
            if (key < root.val)
            {
                partent = root;
                root = root.left;
            }
            else if (key > root.val)
            {
                partent = root;
                root = root.right;
            }
            //找到了
            else
            {
                //被删除的点没有孩子节点
                if (root.left == null && root.right ==null)
                {
                    //根节点
                    if (partent == null)
                        root =null;
                    else if (partent.left == root)
                    {
                        partent.left = null;
                    }
                    else {
                        partent.right = null;
                    }
                }
                //左孩子不空
                else if (root.left != null && root.right == null)
                {
                    if (partent == null)
                    {
                        newTree = root.left;
                    }
                    else if (partent.left == root)
                    {
                        partent.left = root.left;
                    }
                    else
                    {
                        partent.right = root.left;
                    }
                }
                //右孩子不空
                else if (root.left == null && root.right != null)
                {
                    if (partent == null)
                    {
                        newTree = root.right;
                    }
                    else if (partent.left == root)
                    {
                        partent.left = root.right;
                    }
                    else
                    {
                        partent.right = root.right;
                    }
                }
                //两个孩子 这个情况就比较复杂,主要是找到右边孩子节点的最小值, 也就是最左孩子
                else if (root.left != null && root.right != null)
                {
                    TreeNode node = root.right;
                    TreeNode newpartent = null;
                    while (node != null && node.left!= null)
                    {
                        newpartent = node;
                        node = node.left;
                    }
                    int value = root.val;
                    root.val = node.val;

                    if(newpartent == null)
                        root.right = node.right;
                    else if (newpartent.left == node)
                    {
                        newpartent.left =node.right;

                    }
                    else if (newpartent.right == node) {
                        newpartent.right = node.right;

                    }
                }
            }
        }

        return newTree;
    }
}
