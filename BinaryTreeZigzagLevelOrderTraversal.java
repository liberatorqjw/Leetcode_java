package Leetecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-8.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 103 层次遍历只是遍历顺序不是一直的从左到右而是循环的左--右  右--左
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //分层的标识

        TreeNode curnode;
        boolean flag = true; //代表下次的顺序
        List<Integer> ansitem = new ArrayList<>();
        while (!queue.isEmpty())
        {
            curnode = queue.poll();
            if(curnode != null) {

                ansitem.add(curnode.val);
                //下一个已经是第二层了
                //左---右

                if (curnode.left != null) {
                    queue.offer(curnode.left);
                }
                if (curnode.right != null) {
                    queue.offer(curnode.right);
                }
            }
            else
            {
                if(queue.isEmpty())
                {
                    //左---右
                    if(flag) {
                        flag = false;
                        ans.add(ansitem);

                    }
                    else {
                        flag = true;
                        List<Integer> ret = new ArrayList<>();
                        for (int i =ansitem.size()-1; i>=0; i--)
                            ret.add(ansitem.get(i));
                        ans.add(ret);
                    }
                    break;
                }
                else
                {
                    //左---右
                    if(flag) {
                        flag = false;
                        ans.add(ansitem);

                    }
                    else {
                        flag = true;
                        List<Integer> ret = new ArrayList<>();
                        for (int i =ansitem.size()-1; i>=0; i--)
                            ret.add(ansitem.get(i));
                        ans.add(ret);
                    }
                    queue.offer(null);
                    //ans.add(ansitem);
                    ansitem = new ArrayList<>();
                }
            }
        }

        return ans;

    }
}
