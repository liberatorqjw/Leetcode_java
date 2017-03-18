package Leetecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-15.
 */
public class BinarySearchTreeIterator {

    /**
     * BSTIterator
     * 173  二叉搜索树
     * @param root
     */
    public Queue<Integer> queue;
    public BinarySearchTreeIterator(TreeNode root) {

        queue = new LinkedList<>();
        construct(root, queue);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.isEmpty())
            return false;
        return true;

    }

    /** @return the next smallest number */
    public int next() {
        if (queue.isEmpty())
            return 0;
        int value = queue.remove();
        return value;
    }

    public void construct(TreeNode root, Queue<Integer> queue)
    {
        if (root == null)
            return;
        if (root.left != null)
            construct(root.left, queue);
        queue.add(root.val);
        if (root.right != null)
            construct(root.right, queue);
    }
}
