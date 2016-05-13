package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-10.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> path_list = new ArrayList();
        if (root ==null)
            return path_list;

        binarytree(root, "", path_list);
        return path_list;

    }

    public void binarytree(TreeNode node, String current, ArrayList list)
    {
        if (node == null)
            return;
        if(node.left == null && node.right == null)
        {
            if(current == "")
                current = String.valueOf(node.val);
            else
            current += "->" +String.valueOf(node.val);
            list.add(current);
        }
        else
        {
            if (current == "")
            {
                binarytree(node.left, String.valueOf(node.val), list);
                binarytree(node.right,String.valueOf(node.val), list);
            }
            else
            {
                binarytree(node.left, current +"->"+String.valueOf(node.val), list);
                binarytree(node.right, current + "->"+String.valueOf(node.val), list);

            }

        }
    }
}
