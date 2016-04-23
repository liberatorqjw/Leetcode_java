package Leetecode;

import java.util.HashMap;

/**
 * Created by qinjiawei on 16-4-20.
 */
public class BalancedBinaryTree {

    //深度优先，先判断子树
    //map 表示第I节点的深度是多少
    HashMap<TreeNode, Integer> heights = new HashMap<TreeNode, Integer>();

    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            heights.put(null, 0);
            return true;
        }
        if(isBalanced(root.left) && isBalanced(root.right))
        {
            if(Math.abs(heights.get(root.left) - heights.get(root.right)) >1 )
                return false;
            else
            {
                //深度是左右子树的深度加1
                int currentHeight = Math.max(heights.get(root.left), heights.get(root.right)) +1;
                heights.put(root, currentHeight);
                return true;
            }
        }
        else
            return false;


    }
}
