package Leetecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qinjiawei on 16-4-21.
 */
public class BinaryTreeLevelorder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> nextlevel = new LinkedList<>();
        current.add(root);
        boolean isfirst= true;
        List<Integer> tmp = new ArrayList<>();

        while (!current.isEmpty()) {
                TreeNode node = current.remove();
                tmp.add(node.val);
                if (node.left != null)
                    nextlevel.add(node.left);
                if (node.right != null)
                    nextlevel.add(node.right);
                if(current.isEmpty())
                {
                    res.add(tmp);
                    current = nextlevel;
                    nextlevel = new LinkedList<>();
                    tmp = new ArrayList<>();

                }

        }
        return res;

    }
}
