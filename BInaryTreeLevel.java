package Leetecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-4-20.
 */
public class BInaryTreeLevel {

    //层次便利， 但是用两个链表实现 没有用队列
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        TreeNode nextlevel;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<>();

        q.add(root);
        List<Integer> nodevalues = new ArrayList<>();
        while (!q.isEmpty())
        {
            TreeNode currentnode = q.remove();

            if(currentnode.left !=null)
            {
                next.add(currentnode.left);
            }
            if(currentnode.right != null)
                next.add(currentnode.right);

            nodevalues.add(currentnode.val);

            if(q.isEmpty())
            {
                q = next;
                next = new LinkedList<>();
                res.add(nodevalues);
                nodevalues = new ArrayList<>();
            }
        }
        List<List<Integer>> finalres = new ArrayList<>();

        for (int i= res.size()-1; i>=0; i-- )
            finalres.add(res.get(i));
        return finalres;
    }
}
