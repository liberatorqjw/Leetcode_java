package Leetecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-6.
 */
public class BinaryTreeRightSideView {
    /**
     * 199
     * 层次遍历, 每次取最右边的那个
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);//下一层的开始

        TreeNode curnode ;
        while (!queue.isEmpty())
        {
            curnode = queue.poll();
            if(curnode != null)
            {
                //表示下一个节点是下一层了
                if(queue.peek() == null)
                {
                    ans.add(curnode.val);
                }
                if(curnode.left != null)
                    queue.offer(curnode.left);
                if(curnode.right != null)
                    queue.offer(curnode.right);
            }
            else
            {
                //队列是空，表示已经遍历到了最后
                if (queue.isEmpty())
                    break;
                else
                    queue.offer(null); //加入下一个层的分割符号
            }
        }

        if(root == null)
            return ans;

        return ans;

    }
    public void  ConstructList(TreeNode root, List<Integer> ans)
    {
        if (root.left == null && root.right == null)
        {
            ans.add(root.val);
            return;
        }
        else {
            if(root.right != null)
            {
                ans.add(root.val);
                ConstructList(root.right, ans);
            }
            else if (root.left != null)
            {
                ans.add(root.val);
                ConstructList(root.left, ans);
            }

        }
    }
}
