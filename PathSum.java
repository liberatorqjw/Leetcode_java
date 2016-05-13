package Leetecode;

/**
 * Created by qinjiawei on 16-5-6.
 */
public class PathSum {

    /*
    dfs  但是要注意深度优先遍历, 还要注意的就是叶子节点的判定条件
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        boolean resultl = false;


        if(root.right == null && root.left == null)
            return sum==root.val ? true:false;

        //初始的数值 从 0 开始
        resultl = hasPathSum(root, sum, 0);


        return resultl;
    }

    public boolean hasPathSum(TreeNode root, int sum, int curvalue)
    {
        boolean resultl = false;
        boolean resultr = false;

        if(root == null)
            return false;
        //这个条件才是叶子节点
        else if (root.left == null && root.right == null)
            return sum == curvalue + root.val ;
        else
        {
                resultl = hasPathSum(root.left, sum, curvalue + root.val);
                resultr = hasPathSum(root.right, sum, curvalue + root.val);
            return (resultl || resultr);
        }
    }
}
