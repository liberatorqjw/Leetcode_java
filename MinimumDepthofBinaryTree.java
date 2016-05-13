package Leetecode;

/**
 * Created by qinjiawei on 16-5-11.
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
       if (root == null)
           return 0;
        int depth =0;

        return minDepth(root, 0);
    }

    public  int minDepth(TreeNode node, int curdepth)
    {

        if(node == null)
            return 0x7fffffff;
            if (node.left == null && node.right == null)
                return curdepth + 1;
            else
                return Math.min(minDepth(node.right, curdepth + 1), minDepth(node.left, curdepth + 1));

        }

}
