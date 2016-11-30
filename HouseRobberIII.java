package Leetecode;

import java.util.HashMap;

/**
 * Created by qinjiawei on 16-11-24.
 */
public class HouseRobberIII {

    /**
     * 337
     */

    public int rob(TreeNode root) {

        //为了加快查找速度加上hash表
        HashMap<TreeNode, Integer> sum = new HashMap<>();
        return dfs(root, sum);

    }
    public  int dfs(TreeNode root, HashMap<TreeNode, Integer> sum )
    {
        if(root == null)
            return  0;
        int val = 0;
        if(sum.containsKey(root))
            return sum.get(root);
        if(root.left != null)
        {
            val += dfs(root.left.left, sum) + dfs(root.left.right, sum);
        }
        if (root.right != null)
        {
            val += dfs(root.right.left, sum) + dfs(root.right.right, sum);
        }
        //当前节点与隔着的节点求和,然后和它下面的求和,比较大小
        val = Math.max(val + root.val, dfs(root.left,sum) +dfs(root.right, sum) );
        sum.put(root, val);
        return val;

    }
}
