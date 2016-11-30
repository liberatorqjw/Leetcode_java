package Leetecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qinjiawei on 16-11-29.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> path = new Stack<Integer>();

        if (root ==null)
            return ret;

        GetpathSum(root, sum, 0, ret, path);
        return ret;

    }
    public void GetpathSum(TreeNode root, int sum, int curvalue, List<List<Integer>> ret, Stack<Integer> item)
    {
        if(root == null)
            return;
        item.push(root.val);

         if(root.right == null && root.left == null)
        {

            if(sum == root.val + curvalue)
            {

                ret.add((List<Integer>) item.clone());
            }
        }

        GetpathSum(root.left, sum, curvalue+root.val, ret, item);
        GetpathSum(root.right, sum, curvalue+root.val, ret, item);
        item.pop();

    }
}
