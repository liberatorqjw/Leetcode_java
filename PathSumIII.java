package Leetecode;

/**
 * Created by qinjiawei on 16-11-29.
 */
public class PathSumIII {

//    public static int count = 0;

    /**
     * 437
     * 这个题目的几个点
     * 1. 不要用静态变量，可能导致数量重复
     * 2. 由于本题目要求不必须是 头到叶子, 那么就说明哪个节点都可能是头
     * 那么就当成哪个都是可能是头来处理
     * 3. 同样叶子节点的判断也忽略掉.
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {

        int count = 0;
        if(root == null)
            return count;
        count +=GetSum(root, sum);
        count+=pathSum(root.left, sum);
        count+=pathSum(root.right, sum);
        return count;
    }
    public int GetSum(TreeNode root, int sum)
    {
        int ret =0;
        if (root == null)
            return ret;
        if(sum ==  root.val)
        {
            ret++;
        }


        ret +=GetSum(root.left,  sum-root.val);
        ret +=GetSum(root.right,  sum - root.val);
        return ret;

    }
}
