package Leetecode;

import java.math.BigInteger;

/**
 * Created by qinjiawei on 16-11-14.
 */
public class ValidateBinarySearchTree {

    /**
     * 98 题
     * 深度优先遍历
     */

    public boolean isValidBST(TreeNode root) {
        int max = 0xffffffff;
        int min = 0x0fffffff;
        return checkValue(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean checkValue(TreeNode node, long leftvalue , long rightvalue)
    {
        if(node == null)
            return true;
        return node.val > leftvalue && node.val<rightvalue && checkValue(node.left, leftvalue, node.val) && checkValue(node.right, node.val, rightvalue);
    }
}
